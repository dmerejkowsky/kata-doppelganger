using Doppelganger;

namespace Doppelganger.Tests
{
    public class CaluclatorTests
    {


        [Test]
        public void TestDoNotThrowWhenAuthorized()
        {
            var acceptingAuthorizer = new AcceptingAuthorizer();
            var calculator = new Calculator(acceptingAuthorizer);
            var actual = calculator.Add(1, 2);
            Assert.That(actual, Is.EqualTo(3));
        }
    }

    internal class AcceptingAuthorizer : IAuthorizer
    {
        public AcceptingAuthorizer()
        {
        }

        public bool Authorize() => true;

    }
}