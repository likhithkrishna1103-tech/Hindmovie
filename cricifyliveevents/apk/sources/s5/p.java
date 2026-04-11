package s5;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.room.db.AppDatabase;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import v4.x0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11520d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f11521e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f11522g;

    public p(Context context, ArrayList arrayList, kf.i iVar) {
        this.f11521e = context;
        this.f11522g = new ArrayList(arrayList);
        this.f = iVar;
    }

    @Override // v4.z
    public final int a() {
        switch (this.f11520d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f11522g.size();
            default:
                return ((ArrayList) this.f11522g).size();
        }
    }

    @Override // v4.z
    public final long b(int i) {
        switch (this.f11520d) {
        }
        return i;
    }

    @Override // v4.z
    public final int c(int i) {
        int i10 = this.f11520d;
        return i;
    }

    @Override // v4.z
    public final void e(x0 x0Var, final int i) {
        switch (this.f11520d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o oVar = (o) x0Var;
                b6.h hVar = (b6.h) this.f11522g.get(i);
                if (hVar.f) {
                    oVar.f11519y.setVisibility(8);
                }
                oVar.f11516v.setText(hVar.f1810b);
                oVar.f11517w.setText(hVar.f1811c);
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getDefault());
                    oVar.f11518x.setText(simpleDateFormat.format(new Date(hVar.f1814g)));
                    break;
                } catch (Exception unused) {
                }
                oVar.f11515u.setOnClickListener(new d6.b(this, hVar, oVar, 3));
                break;
            default:
                t tVar = (t) x0Var;
                final y5.i iVar = (y5.i) ((ArrayList) this.f11522g).get(i);
                final String str = iVar.f14951a;
                final String str2 = iVar.f14952b;
                final String str3 = iVar.f14953c;
                final String str4 = iVar.f14954d;
                tVar.f11539v.setText(str);
                tVar.f11538u.setOnClickListener(new View.OnClickListener() { // from class: s5.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        x5.r rVar = (x5.r) ((kf.i) this.f11523v.f).f7483w;
                        rVar.f14379w0.f1571y.a(str);
                        String str5 = str3;
                        boolean zIsEmpty = TextUtils.isEmpty(str5);
                        String strConcat = str2;
                        if (!zIsEmpty) {
                            if (!strConcat.contains("/get.php")) {
                                strConcat = strConcat.concat("/get.php");
                            }
                            strConcat = strConcat + "?username=" + str5 + "&password=" + str4 + "&type=m3u";
                        }
                        x5.i iVar2 = rVar.f14378v0;
                        if (iVar2 != null) {
                            iVar2.Y(strConcat, "m3u");
                            ((FloatingActionButton) rVar.f14375s0.f3673x).setVisibility(8);
                            ((SwipeRefreshLayout) rVar.f14375s0.f3675z).setVisibility(8);
                            ((FragmentContainerView) rVar.f14375s0.f3674y).setVisibility(0);
                            return;
                        }
                        rVar.f14378v0 = x5.i.X(strConcat, "m3u", false);
                        r0 r0VarI = rVar.i();
                        r0VarI.getClass();
                        androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0VarI);
                        aVar.f(q5.k.fragment_container, rVar.f14378v0, null, 1);
                        aVar.e(false);
                        ((FloatingActionButton) rVar.f14375s0.f3673x).setVisibility(8);
                        ((SwipeRefreshLayout) rVar.f14375s0.f3675z).setVisibility(8);
                        ((FragmentContainerView) rVar.f14375s0.f3674y).setVisibility(0);
                    }
                });
                tVar.f11540w.setOnClickListener(new View.OnClickListener() { // from class: s5.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        final p pVar = this;
                        Context context = pVar.f11521e;
                        final y5.i iVar2 = iVar;
                        boolean z10 = iVar2.f14955e;
                        final int i10 = i;
                        final String str5 = str;
                        final String str6 = str2;
                        final String str7 = str3;
                        final String str8 = str4;
                        vf.g.X(context, "Edit Playlist Details", "Update", str5, str6, str7, str8, z10, new v5.b() { // from class: s5.s
                            @Override // v5.b
                            public final void a(String str9, String str10, String str11, String str12) {
                                p pVar2 = pVar;
                                Context context2 = pVar2.f11521e;
                                StringBuilder sb = new StringBuilder();
                                sb.append(str5);
                                sb.append("*");
                                sb.append(str6);
                                sb.append("*");
                                sb.append(str7);
                                String strQ = q4.a.q(sb, "*", str8);
                                Set<String> stringSet = com.bumptech.glide.d.t(context2).getStringSet("list", new HashSet());
                                HashSet hashSet = new HashSet();
                                for (String str13 : stringSet) {
                                    if (str13.equals(strQ)) {
                                        hashSet.add(str9 + "*" + str10 + "*" + str11 + "*" + str12);
                                    } else {
                                        hashSet.add(str13);
                                    }
                                }
                                context2.getSharedPreferences("DataPreferences", 0).edit().putStringSet("list", hashSet).apply();
                                ArrayList arrayList = (ArrayList) pVar2.f11522g;
                                y5.i iVar3 = new y5.i(str9, str10, str11, str12, iVar2.f14955e);
                                int i11 = i10;
                                arrayList.set(i11, iVar3);
                                ((x5.r) ((kf.i) pVar2.f).f7483w).f14377u0 = new ArrayList((ArrayList) pVar2.f11522g);
                                pVar2.f13407a.c(i11, 1);
                            }
                        }, new d8.f(i10, pVar, iVar2));
                    }
                });
                break;
        }
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        switch (this.f11520d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_noti, viewGroup, false);
                o oVar = new o(viewInflate);
                oVar.f11515u = (MaterialCardView) viewInflate.findViewById(q5.k.noti_card);
                oVar.f11516v = (TextView) viewInflate.findViewById(q5.k.title);
                oVar.f11517w = (TextView) viewInflate.findViewById(q5.k.content);
                oVar.f11518x = (TextView) viewInflate.findViewById(q5.k.date);
                oVar.f11519y = viewInflate.findViewById(q5.k.read);
                return oVar;
            default:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_playlist, viewGroup, false);
                t tVar = new t(viewInflate2);
                tVar.f11538u = (CardView) viewInflate2.findViewById(q5.k.playlist_card);
                tVar.f11539v = (TextView) viewInflate2.findViewById(q5.k.playlist_name);
                tVar.f11540w = (ImageButton) viewInflate2.findViewById(q5.k.edit_btn);
                return tVar;
        }
    }

    public p(Context context, List list) {
        this.f11521e = context;
        this.f11522g = list;
        this.f = AppDatabase.r(context);
    }
}
