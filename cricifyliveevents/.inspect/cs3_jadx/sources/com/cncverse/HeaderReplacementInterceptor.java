package com.cncverse;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Cricify.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/cncverse/HeaderReplacementInterceptor;", "Lokhttp3/Interceptor;", "customHeaders", "", "", "<init>", "(Ljava/util/Map;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCricify.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cricify.kt\ncom/cncverse/HeaderReplacementInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1068:1\n1915#2,2:1069\n221#3,2:1071\n*S KotlinDebug\n*F\n+ 1 Cricify.kt\ncom/cncverse/HeaderReplacementInterceptor\n*L\n34#1:1069,2\n39#1:1071,2\n*E\n"})
public final class HeaderReplacementInterceptor implements Interceptor {

    @NotNull
    private final Map<String, String> customHeaders;

    public HeaderReplacementInterceptor(@NotNull Map<String, String> map) {
        this.customHeaders = map;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder();
        Iterable $this$forEach$iv = this.customHeaders.keySet();
        for (Object element$iv : $this$forEach$iv) {
            String headerName = (String) element$iv;
            requestBuilder.removeHeader(headerName);
        }
        for (Map.Entry<String, String> entry : this.customHeaders.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            requestBuilder.addHeader(name, value);
        }
        return chain.proceed(requestBuilder.build());
    }
}
