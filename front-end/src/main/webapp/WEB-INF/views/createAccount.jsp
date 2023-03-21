<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

  </head>

  <body>

    <div style="display: flex;
    justify-content: center;
    align-items: center;
    height: 70vh;">
      <div style="    width: 30VW;">
        <form method="POST" action="/account">
          <!-- Name input -->
          <div class="form-outline mb-4">
            <input type="text" id="form5Example1" class="form-control" name="firstname" />
            <label class="form-label" for="form5Example1">Name</label>
          </div>
        
          <!-- surname input -->
          <div class="form-outline mb-2">
            <input type="text" id="form5Example2" class="form-control" name="surname" />
            <label class="form-label" for="form5Example2">Surname</label>
          </div>

          <!-- initial deposit (bank blance input) -->

          <div class="input-group mb-1">
            <div class="input-group-prepend">
              <span class="input-group-text">£</span>
            </div>
            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" name="balance">
            <div class="input-group-append">
              <span class="input-group-text">.00</span>
            </div>
          </div>
          <label class="form-label" for="form5Example2">Initial Deposit Amount</label>
        
          <!-- Checkbox -->
          <div class="form-check">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" value="currentAccount" id="inlineRadio1" >
            <label class="form-check-label" for="inlineRadio1">Current Account</label>
          </div>

          <div class="form-check" style="margin-bottom: 0.5rem;">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" value="savingsAccount" id="inlineRadio2" >
            <label class="form-check-label" for="inlineRadio2">Savings Account</label>
          </div>
        
          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-block mb-4">Apply for your account!</button>
        </form>

      </div>
    </div>
  


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
      integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
      crossorigin="anonymous"></script>
  </body>

  </html>