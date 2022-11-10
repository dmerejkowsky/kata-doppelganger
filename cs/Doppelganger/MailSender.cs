using Microsoft.VisualBasic;
using System.Runtime.ConstrainedExecution;

namespace Doppelganger
{
    public class MailSender
    {
        private const string BASE_URL = "https://mailprovider.com";
        private readonly IHttpClient _httpClient;

        public MailSender(IHttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public void SendV1(User user, string message)
        {
            string name = user.Name;
            string email = user.Email;
            var subject = "New notification";
            // BUG: should be name, email, subject, message
            var sendRequest = new SendRequest(email, name, subject, message);
            _httpClient.Post(BASE_URL, sendRequest);
        }

        public void SendV2(User user, string message)
        {
            string name = user.Name;
            string email = user.Email;
            var subject = "New notification";
            var sendRequest = new SendRequest(name, email, subject, message);
            var response = _httpClient.Post(BASE_URL, sendRequest);
            if (response.Code == 503)
            {
                _httpClient.Post(BASE_URL, response);
            }
        }
    }
}
