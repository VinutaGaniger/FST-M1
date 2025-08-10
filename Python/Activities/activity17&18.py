import pandas as pd

#Writing data to CSV file(Activity 17)
#Create the dataset

data = { 
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charli3", "AllMight"]
}
#Convert the dataset into a DataFrame
df = pd.DataFrame(data)
#Write the DataFrame to a CSV file
df.to_csv("./sample.csv", index=False)

#Reading data from CSV file (Activity 18)
input_data = pd.read_csv("./sample.csv")

print("=======Usernames Colum =======")
print(input_data["Usernames"])

#Print the username and Password of the second row
print("\n=======Second Row Data =======")
print(input_data["Usernames"][1], input_data["Passwords"][1])

print("\n=======Sorted Username Column =======")
print(input_data.sort_values(by="Usernames", ascending=True))

print("\n=======Sorted Passwords Column =======")
print(input_data.sort_values(by="Passwords", ascending=True))