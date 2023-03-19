import React, { useReducer, useEffect, useState } from "react";
import Sidebar from "./containers/Sidebar";
import { Switch, Route, Redirect, useHistory } from "react-router-dom";
import Genre from "./containers/Genre";
import Search from "./containers/Search";
import Person from "./containers/Person";
import Discover from "./containers/Discover";
import MobileMenu from "./containers/MobileMenu";
import Movie from "./containers/Movie";
import Searchbar from "./components/Searchbar";
import NotFound from "./containers/NotFound";
import { INITIAL_APP_STATE } from "./constants/state";
import InitializeReducer from "./reducers/InitializeReducer";
import appInit from "./helpers/AppInitializeHelpers";
import Loader from "./components/Loader";
import { staticCategories as staticCat } from "./constants/state";

function App() {
  const history = useHistory();
  const [selected, setSelected] = useState("Popular");
  const [isMobile, setMobile] = useState(null);
  const [staticCategories] = useState(staticCat);
  const [appState, appDispatch] = useReducer(
    InitializeReducer,
    INITIAL_APP_STATE
  );

  const changeFromMobile = () => {
    window.matchMedia("(min-width: 1024px").matches
      ? setMobile(false)
      : setMobile(true);
  };
  useEffect(() => {
    changeFromMobile();
    window.addEventListener("resize", changeFromMobile);
    appInit(appDispatch, history);
    return () => window.removeEventListener("resize", changeFromMobile);
  }, [appDispatch, history]);

  const { config, loadingApp, genres } = appState;

  if (loadingApp) {
    return (
      <div className="h-screen w-full flex justify-center items-center my-auto">
        <Loader />
      </div>
    );
  }

  return (
    <div className="text-gray-600">
      <div
        className={`w-full min-h-screen ${
          isMobile ? "flex-col" : "flex"
        } items-start`}
      >
        {isMobile ? (
          <MobileMenu
            staticCategories={staticCategories}
            genres={genres}
            selected={selected}
            setSelected={setSelected}
          />
        ) : (
          <>
            <Sidebar
              staticCategories={staticCategories}
              genres={genres}
              selected={selected}
              setSelected={setSelected}
            />
            <div className="z-50 absolute top-6 right-8">
              <Searchbar />
            </div>
          </>
        )}
        <div className="w-full min-h-screen px-4 md:px-8 relative">
          <Switch>
            <Route
              exact
              path={process.env.PUBLIC_URL + "/"}
              render={() => <Redirect to="/filmes/Popular" />}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/genero/:name"}
              render={(routeProps) => (
                <Genre
                  {...routeProps}
                  genres={genres}
                  baseURL={config.secure_base_url}
                  setSelected={setSelected}
                />
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/filmes/:name"}
              render={(routeProps) => (
                <Discover
                  {...routeProps}
                  genres={genres}
                  staticCategories={staticCategories}
                  baseURL={config.secure_base_url}
                  setSelected={setSelected}
                />
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/pesquisa/:query"}
              render={(routeProps) => (
                <Search
                  {...routeProps}
                  baseURL={config.secure_base_url}
                  setSelected={setSelected}
                />
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/filme/:id"}
              baseURL={config.secure_base_url}
              render={(routeProps) => (
                <Movie
                  {...routeProps}
                  setSelected={setSelected}
                  baseURL={config.secure_base_url}
                />
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/elenco/:id"}
              baseURL={config.secure_base_url}
              render={(routeProps) => (
                <Person
                  {...routeProps}
                  setSelected={setSelected}
                  baseURL={config.secure_base_url}
                />
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/404"}
              component={() => (
                <div className="h-screen max-w-7xl mx-auto flex justify-center items-center">
                  <NotFound
                    title="Oops!"
                    subtitle="Página não encontrada..."
                    home
                  />
                </div>
              )}
            />
            <Route
              exact
              path={process.env.PUBLIC_URL + "/error"}
              component={() => (
                <div className="h-screen max-w-7xl mx-auto flex justify-center items-center">
                  <NotFound
                    title="Oops!"
                    subtitle="Algo deu errado..."
                    home
                  />
                </div>
              )}
            />
            <Route
              component={() => (
                <div className="h-screen max-w-7xl mx-auto flex justify-center items-center">
                  <NotFound title="Ooops" subtitle="Página não encontrada..." />
                </div>
              )}
            />
          </Switch>
        </div>
      </div>
    </div>
  );
}

export default App;
