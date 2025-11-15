class SafeCalculator {
  constructor(authorizer) {
    this.authorizer = authorizer;
  }

  add(left, right) {
    const authorized = this.authorizer.authorize();
    // Bug! Should be `if(!authorized)`
    if (authorized) {
      throw new Error("Not authorized");
    }
    return left + right;
  }
}

export default SafeCalculator;
