cd target

# Run the Java application and disown it
java -jar practice-0.0.1-SNAPSHOT.jar && disown

# Function to handle Ctrl+C
ctrl_c() {
    echo "Ctrl+C pressed. Script will now exit."
    exit 1
}

# Trap Ctrl+C to call the ctrl_c function
trap ctrl_c INT
