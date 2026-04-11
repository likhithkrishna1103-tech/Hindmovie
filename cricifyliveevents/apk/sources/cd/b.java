package cd;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum b {
    f2151x("UNKNOWN"),
    f2152y("NONE"),
    f2153z("FILE_NOT_CREATED"),
    A("CONNECTION_TIMED_OUT"),
    B("UNKNOWN_HOST"),
    C("HTTP_NOT_FOUND"),
    D("WRITE_PERMISSION_DENIED"),
    E("NO_STORAGE_SPACE"),
    F("NO_NETWORK_CONNECTION"),
    G("EMPTY_RESPONSE_FROM_SERVER"),
    H("REQUEST_ALREADY_EXIST"),
    I("DOWNLOAD_NOT_FOUND"),
    J("FETCH_DATABASE_ERROR"),
    K("REQUEST_WITH_ID_ALREADY_EXIST"),
    L("REQUEST_WITH_FILE_PATH_ALREADY_EXIST"),
    M("REQUEST_NOT_SUCCESSFUL"),
    N("UNKNOWN_IO_ERROR"),
    O("FILE_NOT_FOUND"),
    P("FETCH_FILE_SERVER_URL_INVALID"),
    Q("INVALID_CONTENT_HASH"),
    R("FAILED_TO_UPDATE_REQUEST"),
    S("FAILED_TO_ADD_COMPLETED_DOWNLOAD"),
    T("FETCH_FILE_SERVER_INVALID_RESPONSE"),
    U("REQUEST_DOES_NOT_EXIST"),
    V("ENQUEUE_NOT_SUCCESSFUL"),
    W("COMPLETED_NOT_ADDED_SUCCESSFULLY"),
    X("ENQUEUED_REQUESTS_ARE_NOT_DISTINCT"),
    Y("FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE"),
    Z("FAILED_TO_RENAME_FILE"),
    f2147a0("FILE_ALLOCATION_FAILED"),
    f2148b0("HTTP_CONNECTION_NOT_ALLOWED");


    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final jb.b f2150w = new jb.b(6);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2154v;

    b(String str) {
        this.f2154v = i;
    }
}
