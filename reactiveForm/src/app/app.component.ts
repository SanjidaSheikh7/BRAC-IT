import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'reactiveForm';
  reactiveForm: FormGroup;

  ngOnInit(): void {
    this.reactiveForm=new FormGroup({
      personalDetail:new FormGroup({
        fullName: new FormControl(null,[Validators.required,this.noSpaceAllowed]),
        email:new FormControl(null,[Validators.required,Validators.email]),
      }),
      mobileNumber:new FormControl(null,Validators.required),
      birthDate:new FormControl(null,Validators.required),
      gender:new FormControl("male",Validators.required),
      address:new FormControl(null,Validators.required),
      country:new FormControl("bd",Validators.required),
      postalCode:new FormControl(null,Validators.required)
    });
  }
  onSubmit(){
    console.log(this.reactiveForm);
  }

  //custom validator
  noSpaceAllowed(control:FormControl){
    if(control.value!=null && control.value.indexOf(' ')!=-1){
      return{noSpaceAllowed:true}
    }
    return null;
  }

}
