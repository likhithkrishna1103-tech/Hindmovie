package v5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.PlayerActivity;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import o.s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends h.h {
    public static final /* synthetic */ int D = 0;
    public u5.b C;

    public static void k(Context context) {
        final m mVar = new m(context, 0);
        Context context2 = mVar.getContext();
        mVar.setTitle("Network Stream");
        View viewInflate = LayoutInflater.from(context2).inflate(q5.l.dialog_ns, (ViewGroup) null, false);
        int i = q5.k.adv;
        CheckBox checkBox = (CheckBox) android.support.v4.media.session.b.l(viewInflate, i);
        if (checkBox != null) {
            i = q5.k.adv_container;
            LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
            if (linearLayout != null) {
                i = q5.k.licence_container;
                TextInputLayout textInputLayout = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                if (textInputLayout != null) {
                    i = q5.k.licence_input;
                    TextInputEditText textInputEditText = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                    if (textInputEditText != null) {
                        i = q5.k.origin_container;
                        TextInputLayout textInputLayout2 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                        if (textInputLayout2 != null) {
                            i = q5.k.origin_input;
                            TextInputEditText textInputEditText2 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                            if (textInputEditText2 != null) {
                                i = q5.k.ref_container;
                                TextInputLayout textInputLayout3 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                                if (textInputLayout3 != null) {
                                    i = q5.k.ref_input;
                                    TextInputEditText textInputEditText3 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                                    if (textInputEditText3 != null) {
                                        i = q5.k.spinner;
                                        Spinner spinner = (Spinner) android.support.v4.media.session.b.l(viewInflate, i);
                                        if (spinner != null) {
                                            i = q5.k.ua_container;
                                            TextInputLayout textInputLayout4 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                                            if (textInputLayout4 != null) {
                                                i = q5.k.ua_input;
                                                TextInputEditText textInputEditText4 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                                                if (textInputEditText4 != null) {
                                                    i = q5.k.url_container;
                                                    TextInputLayout textInputLayout5 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                                                    if (textInputLayout5 != null) {
                                                        i = q5.k.url_input;
                                                        TextInputEditText textInputEditText5 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                                                        if (textInputEditText5 != null) {
                                                            ScrollView scrollView = (ScrollView) viewInflate;
                                                            mVar.C = new u5.b(scrollView, checkBox, linearLayout, textInputLayout, textInputEditText, textInputLayout2, textInputEditText2, textInputLayout3, textInputEditText3, spinner, textInputLayout4, textInputEditText4, textInputLayout5, textInputEditText5);
                                                            h.f fVar = mVar.B;
                                                            fVar.f5327g = scrollView;
                                                            fVar.f5328h = false;
                                                            checkBox.setOnCheckedChangeListener(new k(0, mVar));
                                                            mVar.C.f12221b.setVisibility(8);
                                                            u5.b bVar = mVar.C;
                                                            mVar.j(bVar.f12229l, bVar.f12230m);
                                                            u5.b bVar2 = mVar.C;
                                                            mVar.j(bVar2.f12225g, bVar2.f12226h);
                                                            u5.b bVar3 = mVar.C;
                                                            mVar.j(bVar3.f12224e, bVar3.f);
                                                            u5.b bVar4 = mVar.C;
                                                            mVar.j(bVar4.f12222c, bVar4.f12223d);
                                                            u5.b bVar5 = mVar.C;
                                                            mVar.j(bVar5.f12227j, bVar5.f12228k);
                                                            u5.b bVar6 = mVar.C;
                                                            TextInputLayout textInputLayout6 = bVar6.f12229l;
                                                            int i10 = 5;
                                                            textInputLayout6.setEndIconOnClickListener(new d6.b(mVar, textInputLayout6, bVar6.f12230m, i10));
                                                            u5.b bVar7 = mVar.C;
                                                            TextInputLayout textInputLayout7 = bVar7.f12225g;
                                                            textInputLayout7.setEndIconOnClickListener(new d6.b(mVar, textInputLayout7, bVar7.f12226h, i10));
                                                            u5.b bVar8 = mVar.C;
                                                            TextInputLayout textInputLayout8 = bVar8.f12224e;
                                                            textInputLayout8.setEndIconOnClickListener(new d6.b(mVar, textInputLayout8, bVar8.f, i10));
                                                            u5.b bVar9 = mVar.C;
                                                            TextInputLayout textInputLayout9 = bVar9.f12222c;
                                                            textInputLayout9.setEndIconOnClickListener(new d6.b(mVar, textInputLayout9, bVar9.f12223d, i10));
                                                            u5.b bVar10 = mVar.C;
                                                            TextInputLayout textInputLayout10 = bVar10.f12227j;
                                                            textInputLayout10.setEndIconOnClickListener(new d6.b(mVar, textInputLayout10, bVar10.f12228k, i10));
                                                            final int i11 = 0;
                                                            fVar.c(-1, "Play", new DialogInterface.OnClickListener(mVar) { // from class: v5.j

                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                public final /* synthetic */ m f13433w;

                                                                {
                                                                    this.f13433w = mVar;
                                                                }

                                                                @Override // android.content.DialogInterface.OnClickListener
                                                                public final void onClick(DialogInterface dialogInterface, int i12) {
                                                                    String str;
                                                                    String string;
                                                                    int i13 = i11;
                                                                    m mVar2 = this.f13433w;
                                                                    switch (i13) {
                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                            String string2 = mVar2.C.f12230m.getText().toString();
                                                                            int i14 = 0;
                                                                            if (!TextUtils.isEmpty(string2)) {
                                                                                mVar2.i();
                                                                                String lowerCase = string2.toLowerCase();
                                                                                StringBuilder sb = new StringBuilder(string2);
                                                                                str = "";
                                                                                if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                                                                    String[] strArrSplit = string2.split("\\|");
                                                                                    ArrayList arrayListQ = j4.q(strArrSplit[1], "drmlicense");
                                                                                    StringBuilder sb2 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListQ.get(0)));
                                                                                    if (TextUtils.isEmpty((CharSequence) arrayListQ.get(1))) {
                                                                                        sb = sb2;
                                                                                        string = "";
                                                                                    } else {
                                                                                        string = (String) arrayListQ.get(1);
                                                                                        sb = sb2;
                                                                                    }
                                                                                } else {
                                                                                    string = "";
                                                                                }
                                                                                if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                                                                    String[] strArrSplit2 = sb.toString().split("\\|");
                                                                                    ArrayList arrayListQ2 = j4.q(strArrSplit2[1], "drmscheme");
                                                                                    StringBuilder sb3 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListQ2.get(0)));
                                                                                    str = TextUtils.isEmpty((CharSequence) arrayListQ2.get(1)) ? "" : (String) arrayListQ2.get(1);
                                                                                    sb = sb3;
                                                                                }
                                                                                String string3 = sb.toString();
                                                                                if (string3.indexOf("|") + 1 >= string3.length()) {
                                                                                    sb = new StringBuilder(string3.split("\\|")[0]);
                                                                                }
                                                                                if (mVar2.C.f12220a.isChecked()) {
                                                                                    if (TextUtils.isEmpty(string)) {
                                                                                        string = mVar2.C.f12223d.getText().toString();
                                                                                    }
                                                                                    if (TextUtils.isEmpty(str)) {
                                                                                        str = (String) mVar2.C.i.getSelectedItem();
                                                                                    }
                                                                                    String string4 = mVar2.C.f12226h.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string4) && !lowerCase.contains("referer=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("referer=");
                                                                                        sb.append(string4);
                                                                                    }
                                                                                    String string5 = mVar2.C.f.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string5) && !lowerCase.contains("origin=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("origin=");
                                                                                        sb.append(string5);
                                                                                    }
                                                                                    String string6 = mVar2.C.f12228k.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string6) && !lowerCase.contains("user-agent=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("User-Agent=");
                                                                                        sb.append(string6);
                                                                                    }
                                                                                }
                                                                                String string7 = sb.toString();
                                                                                if (TextUtils.isEmpty(string)) {
                                                                                    string = null;
                                                                                }
                                                                                String lowerCase2 = str.toLowerCase();
                                                                                lowerCase2.getClass();
                                                                                if (lowerCase2.equals("widevine")) {
                                                                                    i14 = 1;
                                                                                } else if (!lowerCase2.equals("clearkey")) {
                                                                                    i14 = 2;
                                                                                }
                                                                                y5.g gVar = new y5.g();
                                                                                gVar.f14938v = null;
                                                                                gVar.f14939w = string7;
                                                                                gVar.f14940x = string;
                                                                                gVar.f14941y = null;
                                                                                gVar.f14942z = "pronull";
                                                                                gVar.A = i14;
                                                                                gVar.B = true;
                                                                                Intent intent = new Intent(mVar2.getContext(), (Class<?>) PlayerActivity.class);
                                                                                intent.putExtra("links_model", gVar);
                                                                                mVar2.getContext().startActivity(intent);
                                                                                mVar2.dismiss();
                                                                            } else {
                                                                                Toast.makeText(mVar2.getContext(), "Please enter Stream Url first!", 0).show();
                                                                            }
                                                                            break;
                                                                        default:
                                                                            mVar2.i();
                                                                            mVar2.dismiss();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            final int i12 = 1;
                                                            fVar.c(-2, "Cancel", new DialogInterface.OnClickListener(mVar) { // from class: v5.j

                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                public final /* synthetic */ m f13433w;

                                                                {
                                                                    this.f13433w = mVar;
                                                                }

                                                                @Override // android.content.DialogInterface.OnClickListener
                                                                public final void onClick(DialogInterface dialogInterface, int i122) {
                                                                    String str;
                                                                    String string;
                                                                    int i13 = i12;
                                                                    m mVar2 = this.f13433w;
                                                                    switch (i13) {
                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                            String string2 = mVar2.C.f12230m.getText().toString();
                                                                            int i14 = 0;
                                                                            if (!TextUtils.isEmpty(string2)) {
                                                                                mVar2.i();
                                                                                String lowerCase = string2.toLowerCase();
                                                                                StringBuilder sb = new StringBuilder(string2);
                                                                                str = "";
                                                                                if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                                                                    String[] strArrSplit = string2.split("\\|");
                                                                                    ArrayList arrayListQ = j4.q(strArrSplit[1], "drmlicense");
                                                                                    StringBuilder sb2 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListQ.get(0)));
                                                                                    if (TextUtils.isEmpty((CharSequence) arrayListQ.get(1))) {
                                                                                        sb = sb2;
                                                                                        string = "";
                                                                                    } else {
                                                                                        string = (String) arrayListQ.get(1);
                                                                                        sb = sb2;
                                                                                    }
                                                                                } else {
                                                                                    string = "";
                                                                                }
                                                                                if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                                                                    String[] strArrSplit2 = sb.toString().split("\\|");
                                                                                    ArrayList arrayListQ2 = j4.q(strArrSplit2[1], "drmscheme");
                                                                                    StringBuilder sb3 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListQ2.get(0)));
                                                                                    str = TextUtils.isEmpty((CharSequence) arrayListQ2.get(1)) ? "" : (String) arrayListQ2.get(1);
                                                                                    sb = sb3;
                                                                                }
                                                                                String string3 = sb.toString();
                                                                                if (string3.indexOf("|") + 1 >= string3.length()) {
                                                                                    sb = new StringBuilder(string3.split("\\|")[0]);
                                                                                }
                                                                                if (mVar2.C.f12220a.isChecked()) {
                                                                                    if (TextUtils.isEmpty(string)) {
                                                                                        string = mVar2.C.f12223d.getText().toString();
                                                                                    }
                                                                                    if (TextUtils.isEmpty(str)) {
                                                                                        str = (String) mVar2.C.i.getSelectedItem();
                                                                                    }
                                                                                    String string4 = mVar2.C.f12226h.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string4) && !lowerCase.contains("referer=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("referer=");
                                                                                        sb.append(string4);
                                                                                    }
                                                                                    String string5 = mVar2.C.f.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string5) && !lowerCase.contains("origin=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("origin=");
                                                                                        sb.append(string5);
                                                                                    }
                                                                                    String string6 = mVar2.C.f12228k.getText().toString();
                                                                                    if (!TextUtils.isEmpty(string6) && !lowerCase.contains("user-agent=")) {
                                                                                        sb.append(sb.toString().contains("|") ? "&" : "|");
                                                                                        sb.append("User-Agent=");
                                                                                        sb.append(string6);
                                                                                    }
                                                                                }
                                                                                String string7 = sb.toString();
                                                                                if (TextUtils.isEmpty(string)) {
                                                                                    string = null;
                                                                                }
                                                                                String lowerCase2 = str.toLowerCase();
                                                                                lowerCase2.getClass();
                                                                                if (lowerCase2.equals("widevine")) {
                                                                                    i14 = 1;
                                                                                } else if (!lowerCase2.equals("clearkey")) {
                                                                                    i14 = 2;
                                                                                }
                                                                                y5.g gVar = new y5.g();
                                                                                gVar.f14938v = null;
                                                                                gVar.f14939w = string7;
                                                                                gVar.f14940x = string;
                                                                                gVar.f14941y = null;
                                                                                gVar.f14942z = "pronull";
                                                                                gVar.A = i14;
                                                                                gVar.B = true;
                                                                                Intent intent = new Intent(mVar2.getContext(), (Class<?>) PlayerActivity.class);
                                                                                intent.putExtra("links_model", gVar);
                                                                                mVar2.getContext().startActivity(intent);
                                                                                mVar2.dismiss();
                                                                            } else {
                                                                                Toast.makeText(mVar2.getContext(), "Please enter Stream Url first!", 0).show();
                                                                            }
                                                                            break;
                                                                        default:
                                                                            mVar2.i();
                                                                            mVar2.dismiss();
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            Executors.newSingleThreadExecutor().execute(new pa.c(10, mVar));
                                                            mVar.show();
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void i() {
        Executors.newSingleThreadExecutor().execute(new e(this, this.C.f12230m.getText().toString(), this.C.f12226h.getText().toString(), this.C.f.getText().toString(), this.C.f12228k.getText().toString(), this.C.f12223d.getText().toString(), (String) this.C.i.getSelectedItem()));
    }

    public final void j(final TextInputLayout textInputLayout, final TextInputEditText textInputEditText) {
        textInputEditText.addTextChangedListener(new s2(this, textInputLayout));
        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: v5.l
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                Editable text = textInputEditText.getText();
                if (text != null) {
                    int length = text.length();
                    TextInputLayout textInputLayout2 = textInputLayout;
                    if (length == 0) {
                        textInputLayout2.setEndIconDrawable(g.e.abc_ic_menu_paste_mtrl_am_alpha);
                        textInputLayout2.setEndIconContentDescription("Paste");
                    } else {
                        textInputLayout2.setEndIconDrawable(q5.j.close_24px);
                        textInputLayout2.setEndIconContentDescription("Clear");
                    }
                }
            }
        });
    }
}
