class SafeCalculator:
    def __init__(self, authorizer):
        self.authorizer = authorizer

    def add(self, left, right):
        authorized = self.authorizer.authorize()
        # Bug! Should be `if not authorized`
        if authorized:
            raise Exception("Not authorized")
        return left + right
