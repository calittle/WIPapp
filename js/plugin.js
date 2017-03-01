function extendFunctions() {
    AdfUIComponent.prototype._oldDeliverEvent = AdfUIComponent.prototype._deliverEvent;
    AdfUIComponent.prototype._deliverEvent= function(x117) {
  
    var pluginId;
        if (x117) {
            if (x117.getType() == 'action'){                
                if (x117.getSource().getComponentType() == 'oracle.adf.RichCommandNavigationItem') {
                    var clientId = x117.getSource().getClientId();
                    var tabIndex;
                    var msg = '';
                    for(var item in x117){
                        msg += item +':'+ x117[item]+'\n';
                    }
                    if (/^pt1:pt_np1:[0-9][0-9]{0,1}:tabIndex$/.test(clientId))
                    {                    
                         // Yes, this is UIShell Tab
                         var startPos = clientId.lastIndexOf('tabIndex');
                         tabIndex = clientId.substring(clientId.lastIndexOf(':', startPos-2)+1,startPos-1);                         
                         pluginId = searchWIPPluginId();
                         if (pluginId!=null)
                            {
                               var strParts = pluginId.split(':');
                               var pluginIndex = strParts[1].replace('pt_region','');
                               if (pluginIndex != tabIndex) {
                                    findPluginAndSaveData(x117);
                                } else {
                                    // Do nothing if click the same tab while WIPPlugin is on page to prevent WIPPlugin reload
                                    x117.cancel();
                                    x117.stopBubbling();
                                }
                            }
                    } else if (/^pt1:pt_region[1-9][0-4]{0,1}:[1-9]:pt1:np1:cni[1-4]$/.test(clientId)) {
                                var srcId = x117.getSource().getClientId();
                                if (searchWIPPluginId()!=null) {
                                    if (srcId.charAt(srcId.length-1) != '4') {
                                        findPluginAndSaveData(x117);
                                    } else {
                                        // Do nothing if click the same tab while WIPPlugin is on page to prevent WIPPlugin reload
                                        x117.cancel();
                                        x117.stopBubbling();
                                    }
                                }
                    }
                    else if( (x117.getSource().getComponentType() == 'oracle.adf.RichCommandNavigationItem') && (x117.getSource().getClientId() == 'pt1:np1:cni3')     ){ 
                        //alert(x117.getSource().getClientId() + '  ::::::::::::::::::::::'); 
                        //document.write(msg); 
                        //closeActivity(x117);
                    }
                    else { 
                    //alert(x117.getSource().getClientId());
                    };
                } else if ((x117.getSource().getComponentType() == 'oracle.adf.RichCommandImageLink') && (x117.getSource().getClientId() == 'pt1:pt_cil1')) {
                        // UIShell Close tab Detected
                        var isht = isHomeTab();
                        //alert('isHomeTab: ' + isht);
                        if (isht) {
                        // Home Tab can not be closed
                            x117.cancel();
                            x117.stopBubbling();
                        } else {
                            // Close other UIShell Tabs beside Home tab
                            // Comment the line below to disable save when click X to close document
                            // findPluginAndSaveData(x117);
                            var my_src = x117.getSource();
                            /*var msg = '';
                            for( var i in x117){
                                msg += ' ['+i+'] = ' + x117[i];
                            }
                            alert(msg);*/
                            if(exit_current_tf){
                                exit_current_tf(x117); 
                            }
                            else{
                                this._oldDeliverEvent(x117);
                            }
                        }
                } else if ((x117.getSource().getComponentType() == 'oracle.adf.RichCommandMenuItem') && (x117.getSource().getClientId() == 'pt1:cmi1')) {
                        // Click Home in menuitem
                        findPluginAndSaveData(x117);
                }
                //else alert(x117.getSource() + " : " + x117.getSource().getClientId()); 
            } 
        }
        this._oldDeliverEvent(x117);
    }    
    function isHomeTab() {
        var re= new RegExp("pt1:pt_region0",'g')
        var el = document.getElementsByTagName('div');
        var hometab = false;
        for(var i=0;i<el.length;i++){            
            if(el[i].id == 'pt1:pt_region0' ){
                //alert('div[id] = ' + el[i].id );
                hometab = true;
                break;
            }
        }
        return hometab;
    }    
}

function findPluginAndSaveData(x117) {
    var plugin = null;
    var pluginId;
    var dirty = '1';
    var last = new Date().getTime();
    if( window.lastUpdate){
        var diff = (last - window.lastUpdate);
        if( diff < 1000){
            // Repeated Saves  
            // Less than 1 seconds ago not allowed
            //alert(x117 + "return -- return " + diff);
            return;
        }
    }
    window.lastUpdate = last;
    //alert(x117 + " save -- save " + window.lastUpdate);
    //x117.cancel();
    //x117.stopBubbling();    
    if ((pluginId = searchWIPPluginId()) != null)
        if ((plugin = document.getElementById(pluginId)) != null) {
         // Check to make sure that plugin already installed
         if (plugin.contentWindow.navObj.plugin != null)
         {
            try {
                dirty = plugin.contentWindow.navObj.plugin.isdirty(); 
                //dirty = '0';
            } catch (err) {
                dirty = '1';
            }
            if (/^1$/.test(dirty)) {
                var rtnStr = plugin.contentWindow.navObj.save();
                if (/success/i.test(rtnStr) ) {
                // alert("return = " + rtnStr);
                } else {
                    var r=confirm("WIPPlugin save failed. Do you want to continue?");
                    if (r==false)
                    {
                        x117.cancel();
                        x117.stopBubbling();
                    }
                }
            }
         }
        }
}

function searchWIPPluginId() {
    var re= new RegExp("WPlugin",'g')
    var el = document.getElementsByTagName('iframe');
    var WPId = null;
    for(var i=0;i<el.length;i++){
        if(el[i].id.match(re)){
            WPId = el[i].id;
            break;
        }
    }
    return WPId;
}



function showFPPopup(event)
{
  event.cancel();
  var source = event.getSource();
  var popupId = null;
  Name = source.getProperty("Name");
  Name1 = source.getProperty("Name1");
  Name2 = source.getProperty("Name2");
  Description = source.getProperty("Description");
  Formid = source.getProperty("Formid");
  var callerid = source.getClientId();
  for (var i=0 ;i <3 ;i++ )
        callerid = callerid.substring(0,callerid.lastIndexOf(':'));

  popupId = callerid + ":formspreviewpopup";

  var popup = AdfPage.PAGE.findComponentByAbsoluteId(popupId);

  if (!popup.isPopupVisible())
  {

    var hints = {};

    popup.show(hints);
  }
}

function fppopupClosedListener(event)
{
  var ifm = event.getSource().findComponent("formspreviewiframe");
  // We set it back to blank because ADF remembers source and adds a /idm prefix
  // next time the popup appears
  ifm.setSource("/blank.html");
}

function fppopupOpenedListener(event)
{
  var ifm = event.getSource().findComponent("formspreviewiframe");
  ifm.setSource(ifm.getProperty("realUrl"));
}

function fvfppopupOpenedListener(event)
{
  var ifm = event.getSource().findComponent("fvformspreviewiframe");
  ifm.setSource(ifm.getProperty("realUrl"));
}

function printProofPopupOpenedListener(event)
{
  var ifm = event.getSource().findComponent("printproofiframe");
  ifm.setSource(ifm.getProperty("realUrl"));
}
function idpopupClosedListener(event)
{
  var ifm = event.getSource().findComponent("inbox_distdc_previewiframe");
  // We set it back to blank because ADF remembers source and adds a /idm prefix
  // next time the popup appears
   if (ifm != null)
    ifm.setSource("/blank.html");
}

function idpopupOpenedListener(event)
{
  var ifm = event.getSource().findComponent("inbox_distdc_previewiframe");
   if (ifm != null)
    ifm.setSource(ifm.getProperty("realUrl"));
}

function JSWIPSave(event) {
   pluginId = findWIPPluginId(event);
   var source = event.getSource();
   var callerid = source.getClientId();
   var sourceid = callerid;
   callerid = callerid.substring(0,callerid.lastIndexOf(':'));
   var popupId = callerid + ":statuspopup";
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	var rtnStr = f.contentWindow.navObj.save();
        if (/success/i.test(rtnStr) ) {
            AdfCustomEvent.queue(source, "showStatus", {popupId:popupId, source:sourceid, responseText:"WIPPLUGIN.STATUS.SAVE.SUCCESS", popupType:"0"});
        } else {
            AdfCustomEvent.queue(source, "showStatus", {popupId:popupId, source:sourceid, responseText:"WIPPLUGIN.STATUS.SAVE.ERROR", popupType:"1", title:"WIPPLUGIN.SAVE.BUTTON.POPUP.TITLE"});
        }
   }
}

function JSWIPComplete(event) {
   pluginId = findWIPPluginId(event);
   var source = event.getSource();
   var callerid = source.getClientId();
   var sourceid = callerid;
   callerid = callerid.substring(0,callerid.lastIndexOf(':'));
   var popupId = callerid + ":statuspopup";
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	var rtnStr = f.contentWindow.navObj.complete();
        if (/All Required Fields Have Data|true/i.test(rtnStr) ) {
            rtnStr = f.contentWindow.navObj.save();
            if (/success/i.test(rtnStr)) {
                AdfCustomEvent.queue(source, "doComplete", {}, false);
            } else AdfCustomEvent.queue(source, "showStatus", {popupId:popupId, source:sourceid, responseText:"WIPPLUGIN.STATUS.SAVE.ERROR", popupType:"1", title:"WIPPLUGIN.SAVE.BUTTON.POPUP.TITLE"});
        } else AdfCustomEvent.queue(source, "showStatus", {popupId:popupId, source:sourceid, responseText:rtnStr, popupType:"1", title:"WIPPLUGIN.COMPLETE.BUTTON.POPUP.TITLE"});
   }
}

function JSWIPPrintProof(event) {
   event.cancel();
   pluginId = findWIPPluginId(event);
   var source = event.getSource();
   var callerid = source.getClientId();
   var sourceid = callerid;
   callerid = callerid.substring(0,callerid.lastIndexOf(':'));
   var popupIdErr = callerid + ":statuspopup";
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	var result = f.contentWindow.navObj.printProof();
        if (result=="success")
        {
            var popupId = callerid + ":printproofpopup";
            var popup = AdfPage.PAGE.findComponentByAbsoluteId(popupId);

            if (!popup.isPopupVisible())
            {
                var hints = {};
                popup.show(hints);
            }
        } else
          AdfCustomEvent.queue(source, "showStatus", {popupId:popupIdErr, source:sourceid, responseText:"WIPPLUGIN.STATUS.SAVE.ERROR", popupType:"1", title:"WIPPLUGIN.SAVE.BUTTON.POPUP.TITLE"});
   }
}

function JSWIPPrevForm(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.previousForm();
   }
}

function JSWIPPrevPage(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.previousPage();
   }
}

function JSWIPNextPage(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.nextPage();
   }
}

function JSWIPNextForm(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.nextForm();
   }
}

function JSWIPZoomIn(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.zoomIn();
   }
}

function JSWIPZoomOut(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.zoomOut();
   }
}

function JSWIPZoomNormal(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.zoomNormal();
   }
}

function JSWIPHideNavBar(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.hideNavBar();
   }
}

function JSWIPShowNavBar(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.showNavBar();
   }
}

function JSWIPToggleNavBar(event) {
   pluginId = findWIPPluginId(event);
   if (pluginId != null)
   {
 	var f = document.getElementById(pluginId);
 	f.contentWindow.navObj.toggleNavBar();
   }
}

function findWIPPluginId(event)
{
    var pid = null;
    try
    {
    var esrc = event.getSource();
    var callerid = esrc.getClientId();
    var fid = callerid.substring(0,callerid.lastIndexOf(':')+1);
    pid = fid+"WPlugin";
    var popupId = fid + ":statuspopup";
    } catch (err) {
        pid = searchWIPPluginId();
    }
    if (pid == null)
        if ((pid = searchWIPPluginId())==null)
            AdfCustomEvent.queue(esrc, "showStatus", {popupId:popupId, source:callerid, responseText:"WIPPLUGIN.STATUS.LOCATE.ERROR", popupType:"1", title:"WIPPLUGIN.STATUS.LOCATE.TITLE"});
    return pid;
}

function setOverFlow(divid)
{
   var pattern =  divid + "$";
   var myexp = new RegExp(pattern);

   var allDivs = top.document.getElementsByTagName("div");
   var numDivs = allDivs.length;

   var scroller = null;
   for(var i=0; i != numDivs+1; i++ )
   {
               if (myexp.test(allDivs[i].id))
 		{
                        scroller = allDivs[i];
                        allDivs[i].style.overflow = 'hidden';
 		}
   }
}
<script type="text/javascript" language="javascript">
          var navObj = new navClass();


          if (/IE[^\]]*/.test(getBrowserInfo())) {
              navObj.browser = "ie";
          }
          else {
              navObj.browser = "other";
          }
          navObj.browser = "ie";

          function getBrowserInfo() {
              Browser = "na";
              if (/Firefox[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
                  //test for Firefox/x.x or Firefox x.x (ignoring remaining digits);
                  var ffversion = new Number(RegExp.$1)// capture x.x portion and store as a number
                  Browser = "FF" + ffversion;
              }
              else if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) {
                  //test for MSIE x.x;
                  var ieversion = new Number(RegExp.$1)// capture x.x portion and store as a number
                  Browser = "IE" + ieversion;
              }
              else if (/Opera[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
                  //test for Opera/x.x or Opera x.x (ignoring remaining decimal places);
                  var oprversion = new Number(RegExp.$1)// capture x.x portion and store as a number
                  Browser = "OP" + oprversion;
              }
              else 
              Browser = "na";

              return Browser;
          }

          function initialize() {              
              try {
                  var plugin = (navObj.browser == "other") ? document.getElementById("plugin") : document.getElementById("plugin");
                  if (plugin) {
                      navObj.plugin = plugin;
                      plugin.focus();
                          //if IE
                          if (navObj.browser == "ie") {
                              plugin.setAttribute('classid', 'clsid:F894A210-B1E8-44D2-A3DB-5C2E86C7408D');
                              plugin.setAttribute('src', 'http://192.168.1.72:7001/wipedit/getwip?uniqueid=b2304ad8-fb3c-428f-8077-f35e8dbcfbcb');
                              var pluginparm = document.createElement("param");
                              pluginparm.setAttribute('name', 'src');
                              pluginparm.setAttribute('value', 'http://192.168.1.72:7001/wipedit/getwip?uniqueid=b2304ad8-fb3c-428f-8077-f35e8dbcfbcb');
                              plugin.appendChild(pluginparm);
                          }
                          plugin.style.height = (550 - 25) + 'px';
                  }
              }
              catch (e) {
                  alert('Exception: ' + e);
              }
              
          }

          function navClass() {
/*
              function zoomOut() {
                  this.plugin.ZoomOut();
              }

              function zoomIn() {
                  this.plugin.ZoomIn();
              }

              function zoomNormal() {
                  this.plugin.ZoomNormal();
              }

              function nextForm() {
                  this.plugin.FormNext();
              }

              function previousForm() {
                  this.plugin.FormPrevious();
              }

              function nextPage() {
                  this.plugin.PageNext();
              }

              function previousPage() {
                  this.plugin.PagePrevious();
              }

              function hideNavBar() {
                  this.plugin.hideNavBar();
              }

              function showNavBar() {
                  this.plugin.showNavBar();
              }

              function toggleNavBar() {
                  this.plugin.toggleNavBar();
              }
*/
              function save() {
                  return this.plugin.cmdGetResponse(260);
              }

              function complete() {
                  return String(this.plugin.cmdGetResponse(262));
              }

 /*             function printProof() {
                  var rsp = this.plugin.cmdGetResponse(260);
                  return rsp;
              }
              this.zoomOut = zoomOut;
              this.zoomIn = zoomIn;
              this.zoomNormal = zoomNormal;
              this.nextForm = nextForm;
              this.previousForm = previousForm;
              this.nextPage = nextPage;
              this.previousPage = previousPage;
              */
              this.save = save;
              this.complete = complete;
/*              this.printProof = printProof;
              this.showNavBar = showNavBar;
              this.hideNavBar = hideNavBar;
              this.toggleNavBar = toggleNavBar;
*/
              this.plugin = null;
              this.browser = null;
          }

          function createButton(value, clickScript) {
              var btn = document.createElement('input');
              btn.setAttribute('type', 'button');
              btn.setAttribute('value', value);
              btn.setAttribute('onclick', clickScript);
              return btn;
          }

          function createButtonIE(value, clickScript) {
              var btn = document.createElement('input');
              btn.setAttribute('type', 'button');
              btn.setAttribute('value', value);
              btn.onclick = new Function(clickScript);
              return btn;
          }

          function createImgButton(value, clickScript) {
              var btn = document.createElement('input');
              btn.setAttribute('type', 'image');
              btn.setAttribute('src', value);
              btn.setAttribute('onclick', clickScript);
              return btn;
          }

          function createImgButtonIE(value, clickScript) {
              var btn = document.createElement('input');
              btn.setAttribute('type', 'image');
              btn.setAttribute('src', value);
              btn.onclick = new Function(clickScript);
              return btn;
          }

          function closeBrowser() {
              var pluginId;
              var plugin;
              var dirty = '1';

              if ((pluginId = parent.searchWIPPluginId()) != null)
                  if ((plugin = parent.document.getElementById(pluginId)) != null) {
                      try {
                          dirty = plugin.contentWindow.navObj.plugin.isdirty();
                      }
                      catch (err) {
                          dirty = '1';
                      }
                      if (/^1$/.test(dirty))
                          plugin.contentWindow.navObj.save();
                  }
          }
        </script>
