package com.cncverse;

import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Cricify.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/cncverse/LoggingInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LoggingInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request req = chain.request();
        RequestBody bodyCopy = req.body();
        BufferedSink buffer = new Buffer();
        if (bodyCopy != null) {
            bodyCopy.writeTo(buffer);
        }
        buffer.readUtf8();
        return chain.proceed(req);
    }
}
