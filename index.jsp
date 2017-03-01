<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1" import="wipedit.Controller, javax.security.auth.*,weblogic.security.Security"
%>
<%
  Boolean haveUID = false;
  Boolean haveTID = false;
  Boolean isUserDocPrep = false;
  Boolean isUserDocVet = false;
  wipedit.Controller ws = new wipedit.Controller(config);  
  String className = "index.jsp";  
   
  String uniqueId = "";
  String taskId = "";
  uniqueId = request.getParameter("uniqueid");
  taskId = request.getParameter("docId");
  
  if (uniqueId != null & uniqueId.length() > 0)
    haveUID = true;
  if (taskId !=null & taskId.length() > 0)
    haveTID = true;
    
    Subject subject = Security.getCurrentSubject();
    if (ws.isUserDocPrep(subject))
      isUserDocPrep = true;
    if (ws.isUserDocVet(subject))
      isUserDocVet = true;

%>
<html lang='en'>
    <head>
        <title>Documaker WIPedit</title>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'/>
        <meta name='viewport' content='width=device-width, initial-scale=1'/>
        <link href='bootstrap-3.3.7-dist/css/bootstrap.min.css'
              rel='stylesheet'/>
        <link rel='stylesheet'
              href='font-awesome-4.7.0/css/font-awesome.min.css'></link>
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
                     
                    <!--<a class='navbar-brand' href='#'>WIPedit</a>-->
                    <div class='collapse navbar-collapse' id='navbarCollapse'>
                        <ul class='nav navbar-nav'>
                            <li>
                                <a id="saveButton" href="#">
                                    <i class='fa fa-floppy-o'
                                       aria-hidden='true'></i> Save</a>
                            </li>
                             
                            <li>
                                <!--<a href='submitwip?uniqueid=<%=uniqueId%>&taskid=<%=taskId%>'>-->
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
        if (!haveUID | !haveTID){        
        %>
            <div class='jumbotron'>
            <% if (!haveUID) { %>
                <p style='error'>Unique ID not specified in request as 'uniqueid'</p>
                <% } 
                if (!haveTID) { %>
                <p style='error'>Task ID(docId) not specified in request as 'docId'</p>
                <% } %>
                <p>Example:</p>
                <pre>http://servername:port/wipedit?uniqueid=[value]&taskid=[value]</pre>
            </div>
            <%
        } else {
        %>
            <div class='row'>
                <iframe class="col-lg-12" id="wipedit"
                        src="wipedit?uniqueid=<%=request.getParameter("uniqueid")%>"
                        frameborder="0" style="overflow: hidden; height: 100%; width: 100%; position: absolute;z-index:-1;" height="100%" width="100%"></iframe>
            </div>
            <% } %>
            <div id="modalmessage" class="modal fade" role="dialog">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">                        
                        <div class="modal-body">
                            <p id="modalmessage_content">Some text in the modal.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav id='pagefooter'
             class='navbar navbar-default navbar-fixed-bottom navbar-inverse'>
            <div class='container'>
                <div class='col-xs-12 text-center navbar-text'>
                    <p id="statusbar" class='text'>Copyright &copy; 2016</p>
                </div>
            </div>
        </nav>
        <script>
          $(document).ready(function () {   
          <%
          if (isUserDocVet) { 
          %>
              $("#saveButton").prop('disabled',true);
          <% } %>
              var plugin = $('#wipedit').contents()[0].getElementsByName('plugin')[0]; 
              if (plugin == null) {
                $("#saveButton").prop('disabled',true);
                $("#submitButton").prop('disabled', true) 
              }              
              $("#saveButton").click(function () {   
                    var plugin = $('#wipedit').contents()[0].getElementsByName('plugin')[0];
                    $("#saveButton").prop('disabled',true);
                    $("#submitButton").prop('disabled', true)                  
                    var rs = plugin.cmdGetResponse(260);                    
                    $("#statusbar").text('Document save result:'+rs);
                    $("#saveButton").prop('disabled',false);              
                    $("#submitButton").prop('disabled', false)
                    window.setTimeout(function () {
                      $("#statusbar").text('Copyright (C) 2016');
                    }, 5000);
              });
              $("#submitButton").click(function (){
                  $('#wipedit').attr('src','submitwip?uniqueid=<%=uniqueId%>&taskid=<%=taskId%>');
                  $("#saveButton").prop('disabled',true);
                  $("#submitButton").prop('disabled', true)
              });              
              $("#closeButton").click(function () { 
                var plugin = $('#wipedit').contents()[0].getElementsByName('plugin')[0];
                if (plugin != null){
                  var dirty = '1';
                  try {
                    dirty = plugin.isdirty();
                    alert('Plugin reports dirty =' +dirty);
                  }catch (err){
                    dirty = '1';
                    alert('There was an error getting dirty value:' + err);
                  }
                  if (/^1$/.test(dirty)){
                    if(confirm('You have unsaved data. Do you wish to close?')){
                      window.close();      
                    }
                  }
                }
              });
          });
        </script>
    </body>
</html>