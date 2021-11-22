class LoginViewModel {
  String _email = "";
  String _password = "";

  void setEmail(String email) => _email = email;
  void setPassword(String password) => _password = password;

  void makeLogin() {
    print(_email);
    print(_password);
  }
}
