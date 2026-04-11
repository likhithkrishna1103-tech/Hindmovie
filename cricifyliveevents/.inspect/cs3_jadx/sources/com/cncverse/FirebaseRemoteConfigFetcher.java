package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FirebaseRemoteConfigFetcher.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0011J \u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/cncverse/FirebaseRemoteConfigFetcher;", "", "<init>", "()V", "PACKAGE_NAME", "", "API_KEY", "getAPI_KEY", "()Ljava/lang/String;", "APP_ID", "getAPP_ID", "PROJECT_NUMBER", "getPROJECT_NUMBER", "client", "Lokhttp3/OkHttpClient;", "fetchRemoteConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProviderApiUrl", "getApiUrls", "Lkotlin/Pair;", "RemoteConfigResponse", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirebaseRemoteConfigFetcher {

    @NotNull
    private static final String PACKAGE_NAME = "com.cricfy.tv";

    @NotNull
    public static final FirebaseRemoteConfigFetcher INSTANCE = new FirebaseRemoteConfigFetcher();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.cncverse.FirebaseRemoteConfigFetcher$getApiUrls$1, reason: invalid class name */
    /* JADX INFO: compiled from: FirebaseRemoteConfigFetcher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.FirebaseRemoteConfigFetcher", f = "FirebaseRemoteConfigFetcher.kt", i = {}, l = {133}, m = "getApiUrls", n = {}, nl = {134}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FirebaseRemoteConfigFetcher.this.getApiUrls((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.FirebaseRemoteConfigFetcher$getProviderApiUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FirebaseRemoteConfigFetcher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.FirebaseRemoteConfigFetcher", f = "FirebaseRemoteConfigFetcher.kt", i = {}, l = {123}, m = "getProviderApiUrl", n = {}, nl = {125}, s = {}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FirebaseRemoteConfigFetcher.this.getProviderApiUrl((Continuation) this);
        }
    }

    private FirebaseRemoteConfigFetcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAPI_KEY() {
        return "AIzaSyAh9jkEU0E_UYxH0m_BKAt-uUSTiTPqhb8";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAPP_ID() {
        return "1:963020218535:android:47ec53252c64fb3c9c7b82";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPROJECT_NUMBER() {
        return "963020218535";
    }

    /* JADX INFO: compiled from: FirebaseRemoteConfigFetcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/cncverse/FirebaseRemoteConfigFetcher$RemoteConfigResponse;", "", "entries", "", "", "appName", "state", "templateVersion", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntries", "()Ljava/util/Map;", "getAppName", "()Ljava/lang/String;", "getState", "getTemplateVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RemoteConfigResponse {

        @Nullable
        private final String appName;

        @Nullable
        private final Map<String, String> entries;

        @Nullable
        private final String state;

        @Nullable
        private final String templateVersion;

        public RemoteConfigResponse() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoteConfigResponse copy$default(RemoteConfigResponse remoteConfigResponse, Map map, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = remoteConfigResponse.entries;
            }
            if ((i & 2) != 0) {
                str = remoteConfigResponse.appName;
            }
            if ((i & 4) != 0) {
                str2 = remoteConfigResponse.state;
            }
            if ((i & 8) != 0) {
                str3 = remoteConfigResponse.templateVersion;
            }
            return remoteConfigResponse.copy(map, str, str2, str3);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.entries;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getState() {
            return this.state;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTemplateVersion() {
            return this.templateVersion;
        }

        @NotNull
        public final RemoteConfigResponse copy(@Nullable Map<String, String> entries, @Nullable String appName, @Nullable String state, @Nullable String templateVersion) {
            return new RemoteConfigResponse(entries, appName, state, templateVersion);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteConfigResponse)) {
                return false;
            }
            RemoteConfigResponse remoteConfigResponse = (RemoteConfigResponse) other;
            return Intrinsics.areEqual(this.entries, remoteConfigResponse.entries) && Intrinsics.areEqual(this.appName, remoteConfigResponse.appName) && Intrinsics.areEqual(this.state, remoteConfigResponse.state) && Intrinsics.areEqual(this.templateVersion, remoteConfigResponse.templateVersion);
        }

        public int hashCode() {
            return ((((((this.entries == null ? 0 : this.entries.hashCode()) * 31) + (this.appName == null ? 0 : this.appName.hashCode())) * 31) + (this.state == null ? 0 : this.state.hashCode())) * 31) + (this.templateVersion != null ? this.templateVersion.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "RemoteConfigResponse(entries=" + this.entries + ", appName=" + this.appName + ", state=" + this.state + ", templateVersion=" + this.templateVersion + ')';
        }

        public RemoteConfigResponse(@Nullable Map<String, String> map, @Nullable String appName, @Nullable String state, @Nullable String templateVersion) {
            this.entries = map;
            this.appName = appName;
            this.state = state;
            this.templateVersion = templateVersion;
        }

        public /* synthetic */ RemoteConfigResponse(Map map, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        @Nullable
        public final Map<String, String> getEntries() {
            return this.entries;
        }

        @Nullable
        public final String getAppName() {
            return this.appName;
        }

        @Nullable
        public final String getState() {
            return this.state;
        }

        @Nullable
        public final String getTemplateVersion() {
            return this.templateVersion;
        }
    }

    @Nullable
    public final Object fetchRemoteConfig(@NotNull Continuation<? super Map<String, String>> continuation) {
        if (StringsKt.isBlank(getAPI_KEY()) || StringsKt.isBlank(getAPP_ID()) || StringsKt.isBlank(getPROJECT_NUMBER())) {
            return null;
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.FirebaseRemoteConfigFetcher$fetchRemoteConfig$2, reason: invalid class name */
    /* JADX INFO: compiled from: FirebaseRemoteConfigFetcher.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.FirebaseRemoteConfigFetcher$fetchRemoteConfig$2", f = "FirebaseRemoteConfigFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nFirebaseRemoteConfigFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirebaseRemoteConfigFetcher.kt\ncom/cncverse/FirebaseRemoteConfigFetcher$fetchRemoteConfig$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,137:1\n15#2:138\n50#3:139\n43#3:140\n*S KotlinDebug\n*F\n+ 1 FirebaseRemoteConfigFetcher.kt\ncom/cncverse/FirebaseRemoteConfigFetcher$fetchRemoteConfig$2\n*L\n104#1:138\n104#1:139\n104#1:140\n*E\n"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String url = "https://firebaseremoteconfig.googleapis.com/v1/projects/" + FirebaseRemoteConfigFetcher.INSTANCE.getPROJECT_NUMBER() + "/namespaces/firebase:fetch";
                        String appInstanceId = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, (Object) null);
                        String payload = StringsKt.trimIndent("\n                    {\n                        \"appInstanceId\": \"" + appInstanceId + "\",\n                        \"appInstanceIdToken\": \"\",\n                        \"appId\": \"" + FirebaseRemoteConfigFetcher.INSTANCE.getAPP_ID() + "\",\n                        \"countryCode\": \"US\",\n                        \"languageCode\": \"en-US\",\n                        \"platformVersion\": \"30\",\n                        \"timeZone\": \"UTC\",\n                        \"appVersion\": \"5.0\",\n                        \"appBuild\": \"50\",\n                        \"packageName\": \"com.cricfy.tv\",\n                        \"sdkVersion\": \"22.1.0\",\n                        \"analyticsUserProperties\": {}\n                    }\n                ");
                        Request request = new Request.Builder().url(url).post(RequestBody.Companion.create(payload, MediaType.Companion.get("application/json"))).header("Content-Type", "application/json").header("Accept", "application/json").header("X-Android-Package", FirebaseRemoteConfigFetcher.PACKAGE_NAME).header("X-Goog-Api-Key", FirebaseRemoteConfigFetcher.INSTANCE.getAPI_KEY()).header("X-Google-GFE-Can-Retry", "yes").build();
                        Response response = FirebaseRemoteConfigFetcher.client.newCall(request).execute();
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        String responseBody = response.body().string();
                        String str = responseBody;
                        if (str == null || StringsKt.isBlank(str)) {
                            return null;
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        RemoteConfigResponse configResponse = (RemoteConfigResponse) $this$readValue$iv$iv.readValue(responseBody, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.FirebaseRemoteConfigFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                        });
                        return configResponse.getEntries();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getProviderApiUrl(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.cncverse.FirebaseRemoteConfigFetcher.C00031
            if (r0 == 0) goto L14
            r0 = r5
            com.cncverse.FirebaseRemoteConfigFetcher$getProviderApiUrl$1 r0 = (com.cncverse.FirebaseRemoteConfigFetcher.C00031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.cncverse.FirebaseRemoteConfigFetcher$getProviderApiUrl$1 r0 = new com.cncverse.FirebaseRemoteConfigFetcher$getProviderApiUrl$1
            r0.<init>(r5)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L31;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L3e
        L31:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = 1
            r0.label = r3
            java.lang.Object r3 = r4.fetchRemoteConfig(r0)
            if (r3 != r2) goto L3e
            return r2
        L3e:
            r2 = r3
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L4d
            java.lang.String r3 = "cric_api2"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L59
        L4d:
            if (r2 == 0) goto L58
            java.lang.String r3 = "cric_api1"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            goto L59
        L58:
            r3 = 0
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.FirebaseRemoteConfigFetcher.getProviderApiUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getApiUrls(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.cncverse.FirebaseRemoteConfigFetcher.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.cncverse.FirebaseRemoteConfigFetcher$getApiUrls$1 r0 = (com.cncverse.FirebaseRemoteConfigFetcher.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.cncverse.FirebaseRemoteConfigFetcher$getApiUrls$1 r0 = new com.cncverse.FirebaseRemoteConfigFetcher$getApiUrls$1
            r0.<init>(r7)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L31;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L3e
        L31:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = 1
            r0.label = r3
            java.lang.Object r3 = r6.fetchRemoteConfig(r0)
            if (r3 != r2) goto L3e
            return r2
        L3e:
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L44
            r2 = 0
            return r2
        L44:
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.String r4 = "cric_api1"
            java.lang.Object r4 = r3.get(r4)
            java.lang.String r5 = "cric_api2"
            java.lang.Object r5 = r3.get(r5)
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.FirebaseRemoteConfigFetcher.getApiUrls(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
