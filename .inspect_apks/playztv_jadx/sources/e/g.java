package e;

import androidx.media3.decoder.DecoderInputBuffer;
import c.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f4224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf.d f4226d;

    public /* synthetic */ g(k kVar, String str, cf.d dVar, int i) {
        this.f4223a = i;
        this.f4224b = kVar;
        this.f4225c = str;
        this.f4226d = dVar;
    }

    @Override // e.c
    public final void a(Object obj) {
        switch (this.f4223a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f4224b;
                ArrayList arrayList = kVar.f2178d;
                LinkedHashMap linkedHashMap = kVar.f2176b;
                String str = this.f4225c;
                Object obj2 = linkedHashMap.get(str);
                cf.d dVar = this.f4226d;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + dVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                arrayList.add(str);
                try {
                    kVar.b(iIntValue, dVar, obj);
                    return;
                } catch (Exception e10) {
                    arrayList.remove(str);
                    throw e10;
                }
            default:
                k kVar2 = this.f4224b;
                ArrayList arrayList2 = kVar2.f2178d;
                LinkedHashMap linkedHashMap2 = kVar2.f2176b;
                String str2 = this.f4225c;
                Object obj3 = linkedHashMap2.get(str2);
                cf.d dVar2 = this.f4226d;
                if (obj3 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + dVar2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj3).intValue();
                arrayList2.add(str2);
                try {
                    kVar2.b(iIntValue2, dVar2, obj);
                    return;
                } catch (Exception e11) {
                    arrayList2.remove(str2);
                    throw e11;
                }
        }
    }

    public void b() {
        this.f4224b.f(this.f4225c);
    }
}
