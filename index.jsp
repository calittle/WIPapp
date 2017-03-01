<!DOCTYPE html>
<%@ page import="wipedit.Controller, javax.security.auth.*,weblogic.security.Security"
%>
<%
  
  Boolean haveUID = true;
  Boolean haveTID = true;
  Boolean isUserDocPrep = false;
  Boolean isUserDocVet = false;
  wipedit.Controller ws = new wipedit.Controller(config);  
  String className = "index.jsp";  
   
  String uniqueId = "";
  String taskId = "";
  
  if (request.getParameter("uniqueid") == null || request.getParameter("uniqueid").trim().length() == 0)
    haveUID = false;
  if (request.getParameter("docId") == null || request.getParameter("docId").trim().length() == 0)
    haveTID = false;
  
  if (haveUID)
    uniqueId = request.getParameter("uniqueid");
  if (haveTID)
    taskId = request.getParameter("docId");
    
    Subject subject = Security.getCurrentSubject();
    if (ws.isUserDocPrep(subject))
      isUserDocPrep = true;
    if (ws.isUserDocVet(subject))
      isUserDocVet = true;

%>
<html lang='en'>
        <head>
        <title>Documaker WIPedit</title>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <!--meta http-equiv='X-Frame-Options' content='SAMEORIGIN'-->
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <meta name='description' content='copyright 2016,2017 Oracle Corporation'>
        <meta name='keywords' content='ODEE,Documaker,WIPedit,WIPapp'>
        <meta name='author' content='Andy Little andy.little@oracle.com'>
        <link href='bootstrap-3.3.7-dist/css/bootstrap.min.css' rel='stylesheet'>
        <link rel='stylesheet' href='font-awesome-4.7.0/css/font-awesome.min.css'>  
        <script src='js/jquery-3.1.1.js'></script>        
        <script src='bootstrap-3.3.7-dist/js/bootstrap.min.js'></script>
    </head>
    <body>
        <header>
            <nav class='navbar navbar-default'>
                <div class='navbar-header'>
                    <button type='button' class='navbar-toggle'
                            data-toggle='collapse'
                            data-target='#navbarCollapse'>
                        <span class='sr-only'>Toggle navigation</span>
                        <span class='icon-bar'></span>
                        <span class='icon-bar'></span>
                        <span class='icon-bar'></span>
                    </button>
                    <div class='collapse navbar-collapse' id='navbarCollapse'>
                        <ul class='nav navbar-nav'>
                            <li>
                                <a id="saveButton" disabled="true" href="#">
                                    <i class='fa fa-floppy-o'
                                       aria-hidden='true'></i> Save</a>
                            </li>
                             
                            <li>                                
                                <a id="submitButton" href="#">
                                  <i class='fa fa-share-square-o'
                                     aria-hidden='true'></i> Submit</a>
                            </li>
                             
                            <li>
                                <a id="closeButton" href="#">
                                    <i class='fa fa-times'
                                       aria-hidden='true'></i> Close</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class='container-fluid'>
            <%
        if (!(haveUID && haveTID)){        
        %>
            <div class='jumbotron'>
            <% if (!haveUID) { %>
                <p style='error'>Unique ID not specified in request as 'uniqueid'</p>
                <% } 
            if (!haveTID) { %>
                <p style='error'>Task ID(docId) not specified in request as 'docId'</p>
                <% } %>
                <p>Example:</p>
                <pre>http://servername:port/wipedit/?uniqueid=[value]&docId=[value]</pre>
            </div>
            <%
        } else {
        %>
            <div class='row'>
              <div class="col-lg-12" id="wipedit">
              <!-- <iframe class="col-lg-12" id="wipedit"
                        src="wipedit?uniqueid=<%=request.getParameter("uniqueid")%>"
                        frameborder="0" style="overflow: hidden; height: 100%; width: 100%; position: absolute;z-index:-1;" height="100%" width="100%"></iframe>
                        -->
                <object type="application/x-dpwfile" width="100%" height="100%" id="plugin" name="plugin" classid="clsid:F894A210-B1E8-44D2-A3DB-5C2E86C7408D" src="wipedit?uniqueid=<%=request.getParameter("uniqueid")%>">
                  <param name="src" value="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/wipedit/wipedit?uniqueid=" + request.getParameter("uniqueid")%>">
                  <param name="classid" value="clsid:F894A210-B1E8-44D2-A3DB-5C2E86C7408D">
                  <param name="dpr_wip_mode" value="ENTRY">
                  <param name="url" value="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>">
                  <param name="type" value="application/x-dpwfile">
                  <param name="plugin_time_out" value="180000">
                  <param name="docsavescript" value="wipedit/savewip">
                  <param name="getscript" value="wipedit/getresource">
                  <param name="cookie" value="<% String cookieName = "username";
                                                  Cookie cookies [] = request.getCookies ();
                                                  if (cookies != null)
                                                  {
                                                    for (int i = 0; i < cookies.length; i++) {
                                                      out.write(cookies[i].getName() + "=" + cookies[i].getValue() +"; "); }
                                                  }
                                                  %>">
                </object>
                </div>
            </div>
            <% } %>            
        
        </div>
        <nav id='pagefooter'
             class='navbar navbar-default navbar-fixed-bottom navbar-inverse'>
            <div class='container'>
                <div class='col-xs-12 text-center navbar-text'>
                    <p id="statusbar" class='text'>Copyright &copy; 2016-2017 Oracle Corporation.</p>
                </div>
            </div>
        </nav>
        
        <script>        
        function positionContainer(){
          var height = "innerHeight" in window 
                      ? window.innerHeight
                      : document.documentElement.offsetHeight;                             
          plugin.style.height = (height - 145) + 'px';
        }
        $(window).resize(function(){
          positionContainer();
        });
    
       $(document).ready(function () {              
            positionContainer();                      
          <%
            if (isUserDocPrep) { 
          %>
              //alert('Document save enabled!');
              $("#saveButton").prop('disabled',false);
          <% } %>                       
              $("#saveButton").click(function () {                
                      
                      //alert('Document save clicked');
                      
                      $("#saveButton").prop('disabled',true);
                      $("#submitButton").prop('disabled', true)                  
                      
                      var rs='not saved';
                      var plugin = document.getElementById('plugin');
                      
                      try{
                        rs = plugin.cmdGetResponse(260);
                      }catch (e){
                        alert('Exception: ' + e.message);
                      }
                      //alert('Document save result:'+rs); 
                      $("#statusbar").text('Document save result:'+rs);                      
                      
                      $("#saveButton").prop('disabled',false);              
                      $("#submitButton").prop('disabled', false)
                      
                      window.setTimeout(function () {
                        $("#statusbar").text('Copyright (C) 2016-2017 Oracle Corporation.');
                      }, 5000);
              });
              $("#submitButton").click(function (){
                  //alert('submit button clicked\nAbout to submit.');
                  $("#saveButton").prop('disabled',true);
                  $("#submitButton").prop('disabled', true)
                  window.location.replace('submitwip?uniqueid=<%=uniqueId%>&taskid=<%=taskId%>');
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
                      window.close();      
                    }
                  }
                }
              });
          });
</script>
<script>function browserDetect(){return(navigator.userAgent.indexOf("Opera")||navigator.userAgent.indexOf("OPR"))!=-1?"Opera":navigator.userAgent.indexOf("Chrome")!=-1?"Chrome":navigator.userAgent.indexOf("Safari")!=-1?"Safari":navigator.userAgent.indexOf("Firefox")!=-1?"Firefox":navigator.userAgent.indexOf("MSIE")!=-1||1==!!document.documentMode?"IE":"unknown"}function pluginDetect(){var a=browserDetect(),b=!1;if("Firefox"==a)for(var c=0;navigator.plugins[c];++c)"DocuMaker plugin"==navigator.plugins[c].name&&(b=!0);else if("IE"==a)try{new ActiveXObject("WIPED01.WipEd01Ctrl.1"),b=!0}catch(a){b=!1}b||alert("The Documaker plugin does not appear to be installed!")}</script>
    </body>
</html>

