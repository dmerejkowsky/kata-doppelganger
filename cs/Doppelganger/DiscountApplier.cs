
namespace Doppelganger
{
    public class DiscountApplier
    {
        private readonly INotifier _notifier;

        public DiscountApplier(INotifier notifier)
        {
            _notifier = notifier;
        }

        public void ApplyV1(double discount, List<User> users)
        {
            // BUG! should be i = 0
            for(int i = 1; i < users.Count; i++)
            {
                var message = $"You've got a discount of {discount}";
                var user = users[i];
                _notifier.Notify(user, message);
            }
        }

        public void ApplyV2(double discount, List<User> users)
        {
            for (int i = 0; i < users.Count; i++)
            {
                var message = $"You've got a discount of {discount}";
                // BUG! should be users[i]
                var user = users[0];
                _notifier.Notify(user, message);
            }
        }
    }
}