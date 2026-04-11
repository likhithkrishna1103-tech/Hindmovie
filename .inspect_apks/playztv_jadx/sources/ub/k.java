package ub;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements o8.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12858u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f12859v;

    public /* synthetic */ k(FirebaseMessaging firebaseMessaging, int i) {
        this.f12858u = i;
        this.f12859v = firebaseMessaging;
    }

    @Override // o8.e
    public final void c(Object obj) {
        int i = this.f12858u;
        FirebaseMessaging firebaseMessaging = this.f12859v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t tVar = (t) obj;
                if (firebaseMessaging.f3579e.h()) {
                    tVar.h();
                }
                break;
            default:
                p7.a aVar = (p7.a) obj;
                o4.c cVar = FirebaseMessaging.f3572l;
                firebaseMessaging.getClass();
                if (aVar != null) {
                    a.a.B(aVar.f10247u);
                    firebaseMessaging.e();
                }
                break;
        }
    }
}
