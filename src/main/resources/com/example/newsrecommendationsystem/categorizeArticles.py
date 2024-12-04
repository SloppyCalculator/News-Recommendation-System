import pandas as pd
from transformers import pipeline

# Initialize the BART model for zero-shot classification
classifier = pipeline("zero-shot-classification", model="facebook/bart-large-mnli")

# Load the dataset (assuming it's a CSV file)
dataset = pd.read_csv('/content/bbc_news_from_oct23_2024.csv')

# Define the categories (labels) you want to classify the article into
candidate_labels = ["Technology", "Sports", "Finance", "Health", "Politics", "Education", "Lifestyle", "Entertainment", "World"]

# Function to classify descriptions
def classify_description(description):
    result = classifier(description, candidate_labels)
    return result['labels'][0]  # Return the label with the highest score

# Extract the descriptions from the 5th column (index 4 since index starts from 0)
dataset['Predicted_Category'] = dataset.iloc[:, 4].apply(classify_description)

# Save the updated dataset with the predicted categories to a new CSV file
dataset.to_csv('categorized_dataset2.csv', index=False)

# Optional: Display the first few rows to check the results
print(dataset.head())
