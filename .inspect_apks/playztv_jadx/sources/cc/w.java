package cc;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends td.g implements ae.p {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2719y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2720z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, rd.c cVar, int i) {
        super(2, cVar);
        this.f2719y = i;
        this.A = obj;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        ke.u uVar = (ke.u) obj;
        rd.c cVar = (rd.c) obj2;
        switch (this.f2719y) {
        }
        return ((w) m(uVar, cVar)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f2719y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new w((f0) this.A, cVar, 0);
            case 1:
                return new w((String) this.A, cVar, 1);
            case 2:
                return new w((m4.a) this.A, cVar, 2);
            case 3:
                return new w((r4.g) this.A, cVar, 3);
            default:
                return new w((ke.m) this.A, cVar, 4);
        }
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        Object objF;
        switch (this.f2719y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                sd.a aVar = sd.a.f11942u;
                int i = this.f2720z;
                if (i == 0) {
                    i5.a.Q(obj);
                    f0 f0Var = (f0) this.A;
                    k4 k4Var = f0Var.f2637d;
                    v vVar = new v(0, f0Var);
                    this.f2720z = 1;
                    if (k4Var.o(vVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                }
                return nd.k.f8990a;
            case 1:
                sd.a aVar2 = sd.a.f11942u;
                int i10 = this.f2720z;
                if (i10 == 0) {
                    i5.a.Q(obj);
                    dc.c cVar = dc.c.f4123a;
                    this.f2720z = 1;
                    obj = cVar.b(this);
                    if (obj == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                }
                Collection<ta.i> collectionValues = ((Map) obj).values();
                String str = (String) this.A;
                for (ta.i iVar : collectionValues) {
                    dc.e eVar = new dc.e(str);
                    iVar.getClass();
                    String str2 = "App Quality Sessions session changed: " + eVar;
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", str2, null);
                    }
                    ta.h hVar = iVar.f12371b;
                    synchronized (hVar) {
                        if (!Objects.equals(hVar.f12369c, str)) {
                            ta.h.a(hVar.f12367a, hVar.f12368b, str);
                            hVar.f12369c = str;
                        }
                    }
                    Log.d("SessionLifecycleClient", "Notified " + dc.d.f4125u + " of new session " + str);
                }
                return nd.k.f8990a;
            case 2:
                sd.a aVar3 = sd.a.f11942u;
                int i11 = this.f2720z;
                if (i11 != 0) {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                    return obj;
                }
                i5.a.Q(obj);
                n4.c cVar2 = ((m4.a) this.A).f8307a;
                this.f2720z = 1;
                Object objB = cVar2.b(this);
                return objB == aVar3 ? aVar3 : objB;
            case 3:
                nd.k kVar = nd.k.f8990a;
                sd.a aVar4 = sd.a.f11942u;
                int i12 = this.f2720z;
                if (i12 != 0) {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                    return kVar;
                }
                i5.a.Q(obj);
                r4.g gVar = (r4.g) this.A;
                this.f2720z = 1;
                r4.t tVar = gVar.f11445a;
                if ((tVar.k() && !tVar.o()) || (objF = gVar.f11446b.f(this)) != aVar4) {
                    objF = kVar;
                }
                return objF == aVar4 ? aVar4 : kVar;
            default:
                sd.a aVar5 = sd.a.f11942u;
                int i13 = this.f2720z;
                if (i13 != 0) {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                    return obj;
                }
                i5.a.Q(obj);
                ke.m mVar = (ke.m) this.A;
                this.f2720z = 1;
                Object objX = mVar.X(this);
                return objX == aVar5 ? aVar5 : objX;
        }
    }
}
