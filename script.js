document.getElementById("booking-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const name = document.getElementById("name").value;
    const roomType = document.getElementById("room-type").value;
    alert(`Room booked successfully for ${name} (${roomType})!`);
});

document.getElementById("order-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const orderName = document.getElementById("order-name").value;
    const foodItem = document.getElementById("food-item").value;
    alert(`${orderName}, your order for ${foodItem} has been placed!`);
});
