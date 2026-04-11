package com.playz.tv.app;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.b;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import pc.a;
import ue.r;
import ue.s;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class IGlideModule extends c {
    @Override // com.bumptech.glide.c
    public final void s(Context context, b bVar, i iVar) {
        s sVar;
        try {
            a aVar = new a();
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{aVar}, null);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            r rVar = new r();
            rVar.a(Collections.singletonList(t.f13047w));
            rVar.b(socketFactory, aVar);
            sVar = new s(rVar);
        } catch (KeyManagementException | NoSuchAlgorithmException e10) {
            Log.e("getOkHttpClient Error", e10.getMessage());
            sVar = new s();
        }
        iVar.l(new b6.b(sVar));
    }
}
