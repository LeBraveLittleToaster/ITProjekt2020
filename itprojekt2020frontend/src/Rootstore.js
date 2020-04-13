import { AppStore } from "./store.js";
import { create } from "mobx-persist";

const hydrate = create({
  storage: localStorage,
  jsonify: true
});

class RootStore {
  AppStore = new AppStore();

  constructor() {
    //rehydrate stores here
    hydrate("app", this.AppStore).then(r => {
      console.log("app has been hydrated")
      r.setIsHydrated(true);
    }
    );
  }
}

export const Store = new RootStore();