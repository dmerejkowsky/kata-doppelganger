class Calculator {
  constructor (authorizer) {
    this.authorizer = authorizer
  }

  divide (numerator, denominator) {
    const authorized = this.authorizer.authorize()
    // Bug! Sholud be `if(!authorized)`
    if (authorized) {
      throw new Error('Not authorized')
    }
    return numerator / denominator
  }
}

module.exports = Calculator
