class DiscountApplier {
  constructor (notifier) {
    this.notifier = notifier
  }

  applyV1 (discount, users) {
    // Bug! Should be `let i = 0`
    for (let i = 1; i < users.length; i++) {
      const message = `You've got a new discount of ${discount}`
      const user = users[i]
      this.notifier.notify(user, message)
    }
  }

  applyV2 (discount, users) {
    for (let i = 0; i < users.length; i++) {
      const message = `You've got a new discount of ${discount}`
      // Bug! Should be `users[i]`
      const user = users[0]
      this.notifier.notify(user, message)
    }
  }
}

module.exports = DiscountApplier
