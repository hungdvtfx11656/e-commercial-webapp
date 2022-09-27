<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login_form">
    <div class="row justify-content-center g-0">
        <div class="col-11 col-md-6">
            <div class="row py-5">
                <div class="col-12 col-md-6">
                    <h2 class="text-center mb-3">Sign in</h2>
                    <form action="Login" method="post">
                        <div class="mb-3">
                            <input type="email" name="login_usr" id="login_usr" class="form-control bg-light" placeholder="Your email address" required>
                        </div>
                        <div class="mb-3">
                            <input type="password" name="login_pwd" id="login_pwd" minlength="8" class="form-control bg-light" placeholder="Your password" required>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="login_remember" name="login_remember">
                            <label class="form-check-label" for="login_remember">Remember me</label>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary rounded-pill w-50">Login</button>
                        </div>
                    </form>
                </div>
                <div class="col-12 col-md-6 d-none d-md-block">
                    <h2 class="text-center mb-3">Welcome back!</h2>
                    <p class="text-center">To keep connected with us please login with your personal info</p>
                </div>
            </div>
        </div>
    </div>
</div>