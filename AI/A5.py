import random


class RestaurantChatbot:

    def __init__(self):
        self.intents = {
            "greeting": {
                "examples": ["hi", "hello", "hey", "good morning", "namaste"],
                "responses": [
                    "Welcome to The Golden Bistro! How may I help you?",
                    "Hello! How can I help you today?",
                ],
            },
            "non_vegetarian": {
                "examples": ["non veg", "chicken", "meat", "fish", "mutton"],
                "responses": [
                    "We serve Butter Chicken and Grilled Fish.",
                    "Our non-veg menu is very popular.",
                ],
            },
            "vegetarian": {
                "examples": ["veg", "vegetarian", "paneer", "tofu", "pure veg"],
                "responses": [
                    "We have many vegetarian dishes available.",
                    "Our veg menu includes Paneer Tikka and Veg Pasta.",
                ],
            },
            "vegan_dietary": {
                "examples": ["vegan", "gluten free", "dairy free", "allergy"],
                "responses": [
                    "We provide vegan and gluten-free food options.",
                    "Please inform us about any allergies before ordering.",
                ],
            },
            "menu": {
                "examples": ["menu", "food list", "price list", "show menu"],
                "responses": [
                    "Our menu includes Indian, Italian and Continental dishes.",
                    "We have starters, main course, desserts and drinks.",
                ],
            },
            "drinks": {
                "examples": ["drinks", "coffee", "juice", "beer", "cocktail"],
                "responses": [
                    "We serve soft drinks, juices, coffee and mocktails.",
                    "Our drinks menu includes fresh juices and cold coffee.",
                ],
            },
            "reservation": {
                "examples": ["book", "reservation", "table", "booking"],
                "responses": [
                    "Please tell me date, time and number of people.",
                    "Table booking is available for all customers.",
                ],
            },
            "location": {
                "examples": [
                    "location",
                    "address",
                    "where are you",
                    "contact",
                    "located",
                ],
                "responses": [
                    "We are located near Central Mall, Downtown.",
                    "You can contact us at +91 9876543210.",
                ],
            },
            "timing": {
                "examples": ["timing", "open", "close", "hours", "time"],
                "responses": [
                    "We are open daily from 9 AM to 10 PM.",
                    "Our kitchen closes at 9:30 PM.",
                ],
            },
            "delivery": {
                "examples": ["delivery", "takeaway", "parcel", "swiggy", "zomato"],
                "responses": [
                    "We provide takeaway and home delivery services via Swiggy and Zomato.",
                    "Home delivery is available, you can order using Swiggy and Zomato.",
                ],
            },
            "payment": {
                "examples": ["payment", "upi", "card", "cash"],
                "responses": [
                    "We accept cash, cards and UPI payments.",
                    "All digital payment methods are accepted.",
                ],
            },
            "complaint": {
                "examples": ["complaint", "bad service", "wrong order", "feedback"],
                "responses": [
                    "We are sorry for the inconvenience.",
                    "Please share your feedback with our manager.",
                ],
            },
            "goodbye": {
                "examples": ["bye", "exit", "quit", "thanks"],
                "responses": [
                    "Goodbye! Visit again.",
                    "Thank you for visiting The Golden Bistro.",
                ],
            },
        }

    def get_response(self, user_input):

        user_input = user_input.lower()

        for intent in self.intents.values():
            for word in intent["examples"]:
                if word in user_input:
                    return random.choice(intent["responses"])

        return "Sorry, I did not understand your request."


def main():

    bot = RestaurantChatbot()

    print("=== Restaurant Chatbot Started ===")
    print("Type 'exit' to quit")

    while True:

        user_input = input("\nYou: ")

        if user_input.lower() == "exit":
            print("Bot: Goodbye!")
            break

        response = bot.get_response(user_input)

        print("Bot:", response)


main()
