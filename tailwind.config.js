const { transparent } = require('daisyui/src/colors');

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./dist/**/*.{html,js}"],
  theme: {
    extend: {},
    container: {
      padding: '2rem'
    }
  },
  plugins: [
    require("@tailwindcss/typography"),
    require("daisyui")
  ],
  daisyui: {
    themes: [
      {
        light: {
          ...require('daisyui/src/colors/themes')['[data-theme=retro]'],
          html: {
            'background': transparent,
          }
      }
    }],
  }
}
