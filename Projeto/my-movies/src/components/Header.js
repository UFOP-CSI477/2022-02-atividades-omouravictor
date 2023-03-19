import React from "react";

function Header({ name }) {
  return (
    <div>
      <h1 className="text-3xl w-full font-thin uppercase ml-4">{name}</h1>
    </div>
  );
}

export default Header;
