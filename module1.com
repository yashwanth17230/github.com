<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
       h1{
            text-align: center;
       }
      .first{
           background-color: grey;
           width: 500px;
           border: 10px solid black ;
           margin: auto;
           margin-bottom: 10px;
      }
      .root{
             display: flex;
             align-content: flex-end;
             align-items: left;
             float:right;
             border-left: 10px solid red;
             border-bottom: 10px solid red;
             background-color: aliceblue;
             text-align: center;
             padding: 5px;
            
             
      }
      .second{
           background-color: grey;
           width: 500px;
           border: 10px solid black ;
           margin: auto;
           margin-bottom: 10px;
      }
      .hello{
             display: flex;
             align-content: flex-end;
             align-items: left;
             float:right;
             border-left: 10px solid red;
             border-bottom: 10px solid red;
             background-color: aquamarine;
             padding:10px;
            
             
      }
      .third{
           background-color: grey;
           width: 500px;
           border: 10px solid black ;
           margin: auto;
      }
      .hi{
             display: flex;
             align-content: flex-end;
             align-items: left;
             float:right;
             border-left: 10px solid red;
             border-bottom: 10px solid red;
             background-color: bisque;
             padding: 10px;
             
            
             
      }
    </style>
        
</head>
<body>
    <h1>OUR MENU</h1>
    <div class="first">
        <div class="root">
          <p>chicken</p>
        </div>
        <p>
           Lorem ipsum dolor sit amet consectetur adipisicing elit. 
           Velit exercitationem ex placeat vitae repellat, modi voluptatum 
           sed, sint tempore pariatur in, natus voluptatem delectus suscipit
           ipsa laboriosam. Non modi cumque libero architecto laudantium explicabo.
        </p>
    </div>
    <div class="second">
        <div class="hello">
            <p>beaf</p>
          </div>
        <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
           Velit exercitationem ex placeat vitae repellat, modi voluptatum 
           sed, sint tempore pariatur in, natus voluptatem delectus suscipit
           ipsa laboriosam. Non modi cumque libero architecto laudantium explicabo.
        </p>
    </div>
    <div class="third">
        <div class="hi">
            <p>sushi</p>
          </div>
        <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
            Velit exercitationem ex placeat vitae repellat, modi voluptatum 
            sed, sint tempore pariatur in, natus voluptatem delectus suscipit
            ipsa laboriosam. Non modi cumque libero architecto laudantium explicabo.
        </p>
    </div>
    
</body>
</html>
