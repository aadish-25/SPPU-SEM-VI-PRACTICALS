# Hospital Rule Based Expert System


def ask(question):
    return input(question + " (yes/no): ").lower().strip()


def show_report(disease, department, advice):
    print("\n---------- MEDICAL REPORT ----------")
    print("Possible Condition :", disease)
    print("Department         :", department)
    print("Advice             :", advice)
    print("------------------------------------")


def patient_analysis():
    print("\nEnter Patient Details")
    name = input("Patient Name: ")
    age = input("Patient Age : ")

    print("\nAnswer the following symptoms:")

    fever = ask("Do you have fever")
    cough = ask("Do you have cough")
    cold = ask("Do you have cold")
    headache = ask("Do you have headache")
    body_pain = ask("Do you have body pain")
    stomach_pain = ask("Do you have stomach pain")
    vomiting = ask("Do you have vomiting")
    chest_pain = ask("Do you have chest pain")
    breathless = ask("Do you have breathing difficulty")
    skin_rash = ask("Do you have skin rash or itching")

    print("\nPatient Name:", name)
    print("Patient Age :", age)

    if fever == "yes" and cough == "yes" and cold == "yes":
        show_report(
            "Common Cold / Flu",
            "General Medicine",
            "Take rest, drink warm water and consult doctor if fever continues.",
        )

    elif fever == "yes" and headache == "yes" and body_pain == "yes":
        show_report(
            "Viral Fever",
            "General Medicine",
            "Drink fluids, take rest and monitor temperature.",
        )

    elif fever == "yes" and body_pain == "yes":
        show_report(
            "Dengue / Typhoid Symptoms",
            "General Medicine",
            "Blood test is recommended. Consult doctor immediately.",
        )

    elif chest_pain == "yes" and breathless == "yes":
        show_report(
            "Heart Related Problem",
            "Cardiology",
            "Avoid physical activity and visit hospital immediately.",
        )

    elif breathless == "yes" and cough == "yes":
        show_report(
            "Asthma / Respiratory Problem",
            "Pulmonology",
            "Avoid dust and consult a pulmonologist.",
        )

    elif headache == "yes" and vomiting == "yes":
        show_report(
            "Migraine",
            "Neurology",
            "Take rest in a quiet place and consult doctor if pain is severe.",
        )

    elif stomach_pain == "yes" and vomiting == "yes":
        show_report(
            "Food Poisoning / Stomach Infection",
            "Gastroenterology",
            "Drink ORS, eat light food and consult doctor if vomiting continues.",
        )

    elif skin_rash == "yes":
        show_report(
            "Skin Allergy / Infection",
            "Dermatology",
            "Avoid scratching and consult a dermatologist.",
        )

    else:
        show_report(
            "Disease not found in rule base",
            "General Physician",
            "Please consult a doctor for proper diagnosis.",
        )


def emergency_services():
    print("\n---------- EMERGENCY SERVICES ----------")
    print("Ambulance Service : Available 24x7")
    print("Emergency Ward    : Available 24x7")
    print("ICU Facility      : Available")
    print("Emergency Number  : 108")


def about_system():
    print("\n---------- ABOUT SYSTEM ----------")
    print("This is a rule-based expert system for hospital diagnosis.")
    print("It takes symptoms as input and applies predefined IF-THEN rules.")
    print("It suggests possible disease, department and basic advice.")
    print("This system is made for educational purposes only.")


def main():
    while True:
        print("\n========== HOSPITAL EXPERT SYSTEM ==========")
        print("1. Patient Symptom Analysis")
        print("2. Emergency Services")
        print("3. About System")
        print("4. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            patient_analysis()
        elif choice == "2":
            emergency_services()
        elif choice == "3":
            about_system()
        elif choice == "4":
            print("Thank you for using the system.")
            break
        else:
            print("Invalid choice. Please try again.")


main()
