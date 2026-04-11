package w4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends xd.h implements fe.p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ Object C;
    public final /* synthetic */ Object D;
    public final /* synthetic */ xd.h E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f13998z = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(t tVar, pe.h hVar, d1.e eVar, vd.c cVar) {
        super(2, cVar);
        this.C = tVar;
        this.D = hVar;
        this.E = eVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        pe.v vVar = (pe.v) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f13998z) {
        }
        return ((u) m(vVar, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f13998z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = new u((t) this.C, (pe.h) this.D, (d1.e) this.E, cVar);
                uVar.B = obj;
                return uVar;
            default:
                return new u((yc.d) this.B, (LinkedHashMap) this.C, (d1.e) this.D, (d1.p) this.E, cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        vd.c cVar;
        switch (this.f13998z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    vd.f fVarC = ((pe.v) this.B).b().C(vd.d.f13721v);
                    ge.i.b(fVarC);
                    vd.e eVar = (vd.e) fVarC;
                    t tVar = (t) this.C;
                    vd.h hVarK = w8.e.k((vd.a) eVar, new b0(eVar));
                    vd.h hVarQ = hVarK.q(new ue.u(hVarK, tVar.f13996h));
                    cVar = (pe.h) this.D;
                    d1.e eVar2 = (d1.e) this.E;
                    this.B = cVar;
                    this.A = 1;
                    obj = pe.x.s(hVarQ, eVar2, this);
                    wd.a aVar = wd.a.f14143v;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cVar = (vd.c) this.B;
                    com.bumptech.glide.c.C(obj);
                }
                cVar.i(obj);
                return rd.l.f11003a;
            default:
                d1.p pVar = (d1.p) this.E;
                int i10 = this.A;
                rd.l lVar = rd.l.f11003a;
                wd.a aVar2 = wd.a.f14143v;
                try {
                } catch (Exception e9) {
                    String message = e9.getMessage();
                    if (message == null) {
                        message = e9.toString();
                    }
                    this.A = 3;
                    pVar.j(message, this);
                    if (lVar != aVar2) {
                        return lVar;
                    }
                }
                if (i10 != 0) {
                    if (i10 == 1 || i10 == 2) {
                        com.bumptech.glide.c.C(obj);
                        return lVar;
                    }
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return lVar;
                }
                com.bumptech.glide.c.C(obj);
                URLConnection uRLConnectionOpenConnection = yc.d.a((yc.d) this.B).openConnection();
                ge.i.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("Accept", "application/json");
                for (Map.Entry entry : ((LinkedHashMap) this.C).entrySet()) {
                    httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            bufferedReader.close();
                            inputStream.close();
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            d1.e eVar3 = (d1.e) this.D;
                            this.A = 1;
                            if (eVar3.j(jSONObject, this) != aVar2) {
                                return lVar;
                            }
                        }
                    }
                } else {
                    this.A = 2;
                    pVar.j("Bad response code: " + responseCode, this);
                    if (lVar != aVar2) {
                        return lVar;
                    }
                }
                return aVar2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(yc.d dVar, LinkedHashMap linkedHashMap, d1.e eVar, d1.p pVar, vd.c cVar) {
        super(2, cVar);
        this.B = dVar;
        this.C = linkedHashMap;
        this.D = eVar;
        this.E = pVar;
    }
}
