
namespace Doppelganger;

public interface IHttpClient
{
    SendMailResponse Post(string url, object request);
}

