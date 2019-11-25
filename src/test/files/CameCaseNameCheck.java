class MyClass {
    public static String getRequestURL(HttpServletRequest request) { // Noncompliant
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateTimeUtils.parseDate(text));
                log.debug("[InitBinder]-全局数据绑定  [{}]->[{}]", text, getAsText());
            }
        });


        if (request == null) {
            return "";
        } else {
            return request.getRequestURL().toString();
        }
    }
}