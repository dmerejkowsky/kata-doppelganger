export interface Authorizer {
  authorize(): boolean
}


export class SafeCalculator {
  authorizer: Authorizer

  constructor(authorizer: Authorizer) {
    this.authorizer = authorizer
  }

  add(left: number, right: number) {
    const authorized = this.authorizer.authorize()
    // Bug! Sholud be `if(!authorized)`
    if (authorized) {
      throw new Error('Not authorized')
    }
    return left + right
  }
}

