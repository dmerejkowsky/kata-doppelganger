
namespace Doppelganger;

public interface IHttpClient
{
    Response Post(string url, object request);
}

