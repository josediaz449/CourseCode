//Implement a class Car in ECMAScript. A car has a fuel efficiency (in miles
//per gallon or the metric equivalent) and a certain fuel level. Supply methods to add fuel,
   // find out the fuel remaining in the tank, and drive a given distance.



class Car {
    constructor(fuelEfficiency,fuelLevel){
        this.fuelLevel = fuelLevel;
        this.fuelEficiency = fuelEfficiency;
    }

    get fuel(){
        return this.fuelLevel;
    }
    addFuel(value){
        this.fuelLevel+=value;
        return this.fuel;
    }
    drive(miles){
        this.fuelLevel=this.fuelLevel-miles/this.fuelEficiency;
        return this.fuel;
    }
}
let car = new Car(15,20);
console.log(car.fuel);
console.log(car.drive(15));
console.log(car.addFuel(1));
