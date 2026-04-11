package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements b5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.j f1126b;

    public /* synthetic */ z(h.j jVar, int i) {
        this.f1125a = i;
        this.f1126b = jVar;
    }

    @Override // b5.d
    public final Bundle a() {
        h.j jVar;
        switch (this.f1125a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                Bundle bundle = new Bundle();
                c.l lVar = this.f1126b.D;
                lVar.getClass();
                LinkedHashMap linkedHashMap = lVar.f1969b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(lVar.f1971d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(lVar.f1973g));
                return bundle;
        }
        do {
            jVar = this.f1126b;
        } while (h.j.p(jVar.o()));
        jVar.R.d(androidx.lifecycle.m.ON_STOP);
        return new Bundle();
    }
}
