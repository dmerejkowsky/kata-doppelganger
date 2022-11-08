class Calculator:
    def __init__(self, authorizer):
        self.authorizer = authorizer

    def divide(self, numerator, denominator):
        authorized = self.authorizer.authorize()
        # Bug! Should be `if not authorized`
        if authorized:
            raise Exception("Not authorized")
        return numerator / denominator
