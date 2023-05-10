import { User } from "./user"

export interface Notifier {
  notify(user: User, message: string): void
}

export class DiscountApplier {
  notifier: Notifier

  constructor(notifier: Notifier) {
    this.notifier = notifier
  }

  applyV1(discount: number, users: User[]) {
    // Bug! Should be `let i = 0`
    for (let i = 1; i < users.length; i++) {
      const message = `You've got a new discount of ${discount}%`
      const user = users[i]
      this.notifier.notify(user, message)
    }
  }

  applyV2(discount: number, users: User[]) {
    for (let i = 0; i < users.length; i++) {
      const message = `You've got a new discount of ${discount}%`
      // Bug! Should be `users[i]`
      const user = users[0]
      this.notifier.notify(user, message)
    }
  }
}