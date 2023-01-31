(ns ls 
  "JS interop helper and Logseq APIs that could be aliased."
  (:require
   ["@logseq/libs"]))

(def show-msg js/logseq.UI.showMsg)
(def get-current-block js/logseq.Editor.getCurrentBlock)
(def get-editing-block-content js/logseq.Editor.getEditingBlockContent)
(def update-block js/logseq.Editor.updateBlock)
(def insert-block js/logseq.Editor.insertBlock)
(def insert-batch-block js/logseq.Editor.insertBatchBlock)
(def register-slash-command js/logseq.Editor.registerSlashCommand)

;; Top level Logseq methods have to be called directly.
;; Defining in any ns won't work
;; (def ready js/logseq.ready)
;; (def use-settings-schema js/logseq.useSettingsSchema)
;; (def show-main-ui js/logseq.showMainUI)
;; (def toggle-main-ui js/logseq.toggleMainUI)
;; (def hide-main-ui js/logseq.hideMainUI)
;; (def provide-model js/logseq.provideModel)
;; (def set-main-ui-inline-style js/logseq.setMainUIInlineStyle)
;; (def show-settings-ui js/logseq.showSettingsUI)

(defn register-js-events []
  (js/document.addEventListener
   "keydown"
   #(do
      (when (= (.-keyCode %) 27) (js/logseq.hideMainUI (clj->js {:restoreEditingCursor true})))
      (.stopPropagation %))
   false)
  (js/document.addEventListener
   "click"
   #(let [clicked (.-target %)
          backdrop (.closest clicked ".url-plus-backdrop")]
      (when (= clicked backdrop)
        (js/logseq.hideMainUI (clj->js {:restoreEditingCursor true}))))))

