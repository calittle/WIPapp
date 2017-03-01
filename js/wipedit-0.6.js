function checkRequired(){
  $("#statusbar").text('Checking required fields...');                      
  var plugin = document.getElementById('plugin');
  var rs = false;
  if(plugin!=null){
      rs = plugin.checkRequiredField();
  }
  window.setTimeout(function () {$("#statusbar").text('Copyright (C) 2016-2017 Oracle Corporation.');}, 1000);
  return rs;
}
function saveDocument(){
  $("#statusbar").text('Saving...');                      
  var rs='not saved';
  var plugin = document.getElementById('plugin');  
  if(plugin!=null){
    rs = plugin.cmdGetResponse(260);
  }
  $("#statusbar").text('Document save result:'+rs);                      
  window.setTimeout(function () {$("#statusbar").text('Copyright (C) 2016-2017 Oracle Corporation.');}, 5000);
  
  if (rs=='success')
    return true;
  else
    return false;
}
function pageFormNav(i){
  var plugin = document.getElementById('plugin');  
  if(plugin!=null){
    switch(i){
        case -2:
          plugin.FormPrevious();
          break;
        case -1:
          plugin.PagePrevious();
          break;
        case 1:
          plugin.PageNext();
          break;
        case 2:
          plugin.FormNext();
          break;
      }
  }
}
function navBar(i){
  var plugin = document.getElementById('plugin');  
  if(plugin!=null){
    switch(i){
      case -1:
        plugin.hideNavBar();
        break;
      case 1:
        plugin.showNavBar(); 
        break;
      case 0:
        plugin.toggleNavBar();
        break;      
    }
  }    
}
function zoom(i){
    var plugin = document.getElementById('plugin');
    if(plugin!=null){
      switch(i){
        case -1:
          plugin.zoomOut();
          break;
        case 0:
          plugin.zoomNormal();
          break;
        case 1:
          plugin.zoomIn();
          break;
        default:
          plugin.zoomNormal();        
      }
    } 
}
function positionContainer(){
  var height = "innerHeight" in window 
    ? window.innerHeight
    : document.documentElement.offsetHeight;                             
  plugin.style.height = (height - 145) + 'px';
}
$(window).resize(positionContainer());    
$(document).ready(function () {              
    positionContainer();             
    if (isUserDocPrep) { 
      $("#saveButton").prop('disabled',false);
    }                        
      $("#saveButton").click(function () {                
            $("#saveButton").prop('disabled',true);
            $("#submitButton").prop('disabled', true)                  
            
            saveDocument();            
            
            $("#saveButton").prop('disabled',false);              
            $("#submitButton").prop('disabled', false)
            
      });
      $("#zoomNormal").click(function(){
        zoom(0);
      }); 
      $("#zoomOut").click(function(){
        zoom(-1);
      }); 
      $("#zoomIn").click(function(){
        zoom(1);
      });
      $("#formprev").click(function(){
        pageFormNav(-2);
      });
      $("#formnext").click(function(){
        pageFormNav(2);
      });
      $("#pageprev").click(function(){
        pageFormNav(-1);
      });
      $("#pagenext").click(function(){
        pageFormNav(1);
      });
      $("#navon").click(function(){
        navBar(1);
      });
      $("#navoff").click(function(){
        navBar(-1);
      });
      $("#navtoggle").click(function(){
        navBar(0);
      });
      $("#proof").click(function (){                            
          $("#statusbar").text('Saving...');
          if (saveDocument()){          
            $("#statusbar").text('Generating PDF...');
            window.open('printwip?uniqueid='+uniqueid);
          }window.setTimeout(function () {$("#statusbar").text('Copyright (C) 2016-2017 Oracle Corporation.');}, 5000);
      });       
      $("#checkRequired").click(function (){
          if(checkRequired()=='true')
            alert('All required fields are completed. Nice job!');
      }); 
      $("#submitButton").click(function (){
            if(checkRequired()=='true'){
              $("#statusbar").text('Saving...');                      
              if (saveDocument()){
                $("#statusbar").text('Submitting...');                      
                window.setTimeout(function () {$("#statusbar").text('Copyright (C) 2016-2017 Oracle Corporation.');}, 5000);
                window.location.replace('submitwip?uniqueid='+uniqueid+'&taskid=' + taskid);
              }
            }  
      });       
      $("#closeButton").click(function () { 
        var plugin = document.getElementById('plugin');
        if (plugin != null){
          var dirty = '1';
          try {
            dirty = plugin.isdirty();                    
          }catch (err){
            dirty = '1';
          }
          if (/^1$/.test(dirty)){
            if(confirm('You may have unsaved data. Do you wish to close?')){
              //open(location,'_self').close();
              window.close();
            }
          }
        }
      });
      if (pluginDetect()==false){
        $("#saveButton").prop('disabled',true);
        $("#submitButton").prop('disabled', true)
      }
  });
function browserDetect(){return(navigator.userAgent.indexOf("Opera")||navigator.userAgent.indexOf("OPR"))!=-1?"Opera":navigator.userAgent.indexOf("Chrome")!=-1?"Chrome":navigator.userAgent.indexOf("Safari")!=-1?"Safari":navigator.userAgent.indexOf("Firefox")!=-1?"Firefox":navigator.userAgent.indexOf("MSIE")!=-1||1==!!document.documentMode?"IE":"unknown"}function pluginDetect(){var a=browserDetect(),b=false;if("Firefox"==a)for(var c=0;navigator.plugins[c];++c)"DocuMaker plugin"==navigator.plugins[c].name&&(b=true);else if("IE"==a)try{new ActiveXObject("WIPED01.WipEd01Ctrl.1"),b=true}catch(a){b=false;}return(b);}
if(pluginDetect()==false){$("#statusbar").text('No plugin installed! - Copyright (C) 2016-2017 Oracle Corporation.');alert("The Documaker plugin does not appear to be installed!");}
