const sendData = () => {
    const xhr = new XMLHttpRequest();
    const formData = new FormData(myform);

    // getting age from the form 
    const age  = formData.get('age');
    for (const pair of formData.entries()) {
        console.log(pair[0], pair[1]);
    }


    xhr.open('POST',`http://localhost:8080/form/register/${age}`)
    xhr.setRequestHeader('X-Custom-header','1001')
    xhr.send(formData)

    //rendering the list of users
    xhr.onloadend =()=>{
        userdetails.innerHTML = '';
        updateData();
    }
    myform.reset();
    myprofile.src = 'user.png';
}

myform.addEventListener('submit', (e) => {
    e.preventDefault();
    sendData();
    updateData();
});

profile.onchange = evt => {
    const [file] = profile.files
    if (file) {
        myprofile.src = URL.createObjectURL(file)
    }
  }

 const createUserCard=(user)=> {
            let cardContainer = document.createElement('div');
            cardContainer.classList.add('card');

            let imgElement = document.createElement('img');
            imgElement.src = 'data:image/jpeg;base64,' + user.profile;
            imgElement.alt = user.firstname;
            imgElement.classList.add('profile-image');

            let nameElement = document.createElement('h4');
            nameElement.textContent = 'Name: '+user.firstname + ' '+user.lastname;
            nameElement.classList.add('profile-name');

            let emailElement = document.createElement('p');
            emailElement.textContent ='Email: '+ user.email;
            emailElement.classList.add('profile-text');

            let ageElement = document.createElement('p');
            ageElement.textContent ='Age : '+ user.age;
            ageElement.classList.add('profile-text');

            let phoneElement = document.createElement('p');
            phoneElement.textContent ='Phone : '+ user.phone;
            phoneElement.classList.add('profile-text');

            cardContainer.appendChild(imgElement);
            cardContainer.appendChild(nameElement);
            cardContainer.appendChild(emailElement);
            cardContainer.appendChild(phoneElement);
            cardContainer.appendChild(ageElement);

            return cardContainer;
 }


const updateData = ()=>{
const xhr = new XMLHttpRequest()
xhr.open('GET','http://localhost:8080/form/getUsers')
xhr.onload = () =>{
    res  =JSON.parse(xhr.response)
    console.log('json',res)
    res.map((user)=>{
        let card  = createUserCard(user)
        userdetails.appendChild(card)}
    )
}
xhr.send(null);}

updateData();
