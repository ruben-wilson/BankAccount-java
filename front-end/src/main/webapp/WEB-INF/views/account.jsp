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
            <a class="navbar-brand" href="#">
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
                          <h3>Deposit</h3>
                          <span>from account</span>
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
                          <h3>Withdraw</h3>
                          <span>from account</span>
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
          </section>

          <!-- transactions table -->
          <section>
            
            <div style="justify-content: center; display: flex;">
              <div class="col-xl-10">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">First</th>
                      <th scope="col">Last</th>
                      <th scope="col">Handle</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                    </tr>
                    <tr>
                      <th scope="row">2</th>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                    </tr>
                    <tr>
                      <th scope="row">3</th>
                      <td colspan="2">Larry the Bird</td>
                      <td>@twitter</td>
                    </tr>
                  </tbody>
              
                </table>
              
              
              </div>

            </div>
            

          </section>
          </div>



          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
        </body>

        </html>