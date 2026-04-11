package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.j f1407b;

    public /* synthetic */ w(h.j jVar, int i) {
        this.f1406a = i;
        this.f1407b = jVar;
    }

    @Override // x4.c
    public final Bundle a() {
        h.j jVar;
        switch (this.f1406a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                Bundle bundle = new Bundle();
                c.k kVar = this.f1407b.C;
                kVar.getClass();
                LinkedHashMap linkedHashMap = kVar.f2176b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(kVar.f2178d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(kVar.f2180g));
                return bundle;
        }
        do {
            jVar = this.f1407b;
        } while (h.j.p(jVar.o()));
        jVar.Q.d(androidx.lifecycle.m.ON_STOP);
        return new Bundle();
    }
}
