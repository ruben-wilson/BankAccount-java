<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.frontend.model.Account" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css"
        href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
      <link rel="stylesheet" type="text/css"
        href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
      <link rel="stylesheet" type="text/css"
        href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
      <link rel="stylesheet" type="text/css"
        href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
      <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
  </head>

  <body>
    <!-- nav bar -->
      <nav class="navbar navbar-light " style="background-color: #F5F7FA;">
        <a class="navbar-brand" href="#">
          <img src="https://www.bankinnovationignite.com/wp-content/uploads/2022/07/bankinnovationignite.com_.jpg" width="30" height="30" class="d-inline-block align-top"
            alt="">
          BankApp
        </a>
      </nav>
      <!-- nav bar -->
          <div class="row" style="margin-left: 2rem; margin-right: 2rem; margin-top: 4rem; justify-content: space-between;">
            <div class="col-xl-3 col-sm-6 col-12">
              <div class="card">
                <div class="card-content">
                  <div class="card-body">
                    <div class="media d-flex">
                      <div class="align-self-center">
                        <i class="icon-diamond primary font-large-2 float-left"></i>
                      </div>
                      <div class="media-body text-right">
                        <h3>Saving Accounts</h3>
                        <span></span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          
            <div class="col-xl-3 col-sm-6 col-12">
              <form action="/account" method="get">
              <div class="card">
                <div class="card-content">
                  <div class="card-body">
                    <div class="media d-flex">
                      <div class="align-self-center">
                      
                        <button type="submit" class="btn" >
                          <i class="icon-settings success font-large-2 float-left"></i>
                        </button>
                        
                      </div>
                      <div class="media-body text-right">
                        <h3>Request new Account</h3>
                        <span></span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              </form>
            </div>
        
            
            <div class="col-xl-3 col-sm-6 col-12">
              <div class="card">
                <div class="card-content">
                  <div class="card-body">
                    <div class="media d-flex">
                      <div class="align-self-center">
                        <i class="icon-credit-card danger font-large-2 float-left"></i>
                      </div>
                      <div class="media-body text-right">
                        <h3>Current Accounts</h3>
                        <span></span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        
      <!-- bank accounts -->
        <section id="stats-subtitle">
      
          <div class="row" >

              <%
              List<Account> accountList = (List<Account>) request.getAttribute("userAccounts");
                for(Account account : accountList){
              %>
                      <div class="col-xl-6 col-md-12">
                        <% String accountUrl = "/account/" + account.getId(); %>
                        <form action=<%= accountUrl %>>
                          <div class="card overflow-hidden">
                            <div class="card-content">
                              <div class="card-body cleartfix">
                                <div class="media align-items-stretch">
                                  <div class="align-self-center">
                                    <% String icon = account.getType().equals("savingsAccount") ? "icon-diamond warning font-large-2 mr-2" : "icon-credit-card warning font-large-2 mr-2";
                                    %>
                                    <button type="submit" class="btn">
                                    <i class="icon-settings warning font-large-2 mr-2" ></i>
                                    </button>
                                  </div>
                                  <div class="media-body">
                                    <h4><%= account.getType().equals("savingsAccount") ? "Savings Account" : "Current Account" %></h4>
                                    <span><%= account.getAccountNum() %></span>
                                  </div>
                                  <div class="align-self-center">
                                    <h1>£ <%= account.getBalance() %></h1>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </form>
                      </div>
                <% } %>

      
          <div class="row">

            <div class="col-xl-6 col-md-12">
              <div class="card">
                <div class="card-content">
                  <div class="card-body cleartfix">
                    <div class="media align-items-stretch">
                      <div class="align-self-center">
                        <h1 class="mr-2">£ <%= request.getAttribute("totalMoney")%></h1>
                      </div>
                      <div class="media-body">
                        <h4>Net Balance</h4>
                        <span>Total balance across all accounts</span>
                      </div>
                      <div class="align-self-center">
                        <i class="icon-trophy danger font-large-2"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
      
            <div class="col-xl-6 col-md-12">
              <div class="card">
                <div class="card-content">
                  <div class="card-body cleartfix">
                    <div class="media align-items-stretch">
                      <div class="align-self-center">
                        <h1 class="mr-2">£ <%= request.getAttribute("totalSavings")%></h1>
                      </div>
                      <div class="media-body">
                        <h4>Total Savings</h4>
                        <span>across all accounts</span>
                      </div>
                      <div class="align-self-center">
                        <i class="icon-diamond primary font-large-2"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>

     

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
      integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
      crossorigin="anonymous"></script>
  </body>

  </html>