namespace Doppelganger;

public class SafeCalculator
{
    private readonly IAuthorizer _authorizer;

    public SafeCalculator(IAuthorizer authorizer)
    {
        _authorizer = authorizer;
    }

    public int Add(int x, int y)
    {
        bool authorized = _authorizer.Authorize();
        // BUG! Should be if(!authorized)
        if (authorized)
        {
            throw new Exception("Not authorized");
        }
        return x + y;
    }
}
