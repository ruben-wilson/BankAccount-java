<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <%@ page import="java.util.ArrayList" %>
  <%@ page import="java.util.List" %>
  <%@ page import="com.bank.frontend.model.Account" %>
  <%@ page import="com.bank.frontend.model.Transaction" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>DashBoard</title>
          
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
          <link rel="stylesheet" type="text/css"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
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
            <a class="navbar-brand" href="/">
              <img src="https://www.bankinnovationignite.com/wp-content/uploads/2022/07/bankinnovationignite.com_.jpg"
                width="30" height="30" class="d-inline-block align-top" alt="">
              BankApp
            </a>
          </nav>
          <!-- nav bar -->
          <section>

            <% Account account = (Account) request.getAttribute("account");%>
            <div style="display: flex; justify-content: center;">
              <div class="col-xl-10 col-md-12">
                <div class="card">
                  <div class="card-content">
                    <div class="card-body cleartfix">
                      <div class="media align-items-stretch">
                        <div class="align-self-center">
                          <h1 class="mr-2">£ <%= account.getBalance() %>
                          </h1>
                        </div>
                        <div class="media-body" style="justify-content: space-around; display: flex;">
                          <div>
                            <% String name = account.getFirstname() + " " + account.getSurname(); %>
                            <h3>
                              <%= name %>
                            </h3>
                            <h4>
                              <%= account.getType().equals("savingsAccount") ? "Savings Account" : "Current Account" %>
                            </h4>
                          </div>
                          <div>
                            <h3>
                              Account Num:
                            </h3>
                            <h4>
                              <%= account.getAccountnum() %>
                            </h4>
                          </div>
                
                        </div>
                        <div class="align-self-center">
                        
                          <img src="https://www.bankinnovationignite.com/wp-content/uploads/2022/07/bankinnovationignite.com_.jpg" width="40"
                            height="40" class="d-inline-block align-top" alt="">
                        
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>

          <!-- withdraw and deposit buttons -->
          
          <section>
            <div style="justify-content: space-around; display: flex;">

              <div class="col-xl-3 col-sm-6 col-12">
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        <div class="align-self-center">  
                            <i class="icon-login danger font-large-2 float-left"></i>
                        </div>
                        <div class="media-body text-right">     
                            <div class="btn-group dropend">
                              <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#depositForm" aria-expanded="false" aria-controls="depositForm">
                                <h3>Deposit</h3>
                              </button>
                            </div>
                          
                        </div>
                      </div>
                    </div>
                  </div> 
                </div>
              </div>

              <div class="col-xl-3 col-sm-6 col-12">
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        
                        <div class="media-body text-left">

                          <div class="btn-group">
                            <button class="btn btn-secondary" type="button" data-toggle="collapse" data-target="#withDrawFrom" aria-expanded="false" aria-controls="withDrawFrom">
                              <h3>
                                Withdraw
                              </h3>
                            </button>
                            
                          </div>

                        </div>
                        <div class="align-self-center">
                          <i class="icon-logout danger font-large-2 float-left"></i>
                        </div>

                      </div>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          

            <!-- deposit form -->
            <% String transactionUrl="/transaction/" + account.getId(); %>
            <div style="justify-content: space-around; display: flex;">
              <div class="col-xl-3 col-sm-6 col-12">
                <div class="collapse card" id="depositForm">
                  <div class="card-content">
                    <div class="card-body" style="display: flex; justify-content: center;">
                      <form method="post" action=<%= transactionUrl %>>
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text">£</span>
                          </div>
                          <input type="text" name="amount" class="form-control" >
                          <input type="hidden" name="transactionType" value="deposit">
                          <div class="input-group-append">
                            <span class="input-group-text">.00</span>
                          </div>
                        </div>
                        <button type="submit" class="btn btn-primary mt-1 ml-5">Make Deposit</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            <!-- withdraw form -->
              <div class="col-xl-3 col-sm-6 col-12">
                <div class="collapse card" id="withDrawFrom">
                  <div class="card-content">
                    <div class="card-body" style="display: flex; justify-content: center;">
                      <form method="post" action=<%= transactionUrl %> >
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text">£</span>
                          </div>
                          <input type="text" name="amount" class="form-control">
                          <input type="hidden" name="transactionType" value="withdraw">
                          <div class="input-group-append">
                            <span class="input-group-text">.00</span>
                          </div>
                        </div>
                        <button type="submit" class="btn btn-primary mt-1 ml-5">Make Withdraw</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>

          <!-- transactions table -->
          <section>
            
            <div style="justify-content: center; display: flex;">
              <div class="col-xl-10">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th scope="col">Transaction Type</th>
                      <th scope="col">Amount</th>
                      <th scope="col">Account balance</th>
                      <th scope="col">Date</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% 
                      List<Transaction> transactionList = (List<Transaction>) request.getAttribute("transactions"); 
                      for(Transaction t : transactionList){
                      %>
                        <tr>
                          <td><%= t.getTransactionType()%></td>
                          <td><%= t.getAmount()%></td>
                          <td><%= t.getBalance()%></td>
                          <td><%= t.getDate()%></td>
                        </tr>
                    <% }%>
                    
                  </tbody>
              
                </table>
              </div>

            </div>
            

          </section>
          </div>



          <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
  integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
  integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        </body>

        </html>