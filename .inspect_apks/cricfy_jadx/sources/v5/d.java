package v5;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import o.j0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends androidx.fragment.app.q {
    public l7.a I0;
    public ArrayList J0;
    public x5.g K0;

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        final int i = 0;
        ((RelativeLayout) this.I0.f7866w).setOnClickListener(new View.OnClickListener(this) { // from class: v5.c

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ d f13416w;

            {
                this.f13416w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f13416w.R(false, false);
                        break;
                    default:
                        this.f13416w.R(false, false);
                        break;
                }
            }
        });
        final int i10 = 1;
        ((ImageButton) this.I0.f7867x).setOnClickListener(new View.OnClickListener(this) { // from class: v5.c

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ d f13416w;

            {
                this.f13416w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f13416w.R(false, false);
                        break;
                    default:
                        this.f13416w.R(false, false);
                        break;
                }
            }
        });
        ((ListView) this.I0.f7868y).setAdapter((ListAdapter) new ArrayAdapter(j(), q5.l.item_choose_tab, q5.k.choose_txt, this.J0));
        ((ListView) this.I0.f7868y).setOnItemClickListener(new j0(3, this));
    }

    @Override // androidx.fragment.app.q
    public final Dialog S(Bundle bundle) {
        Dialog dialogS = super.S(bundle);
        dialogS.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogS.setCancelable(true);
        dialogS.setCanceledOnTouchOutside(true);
        return dialogS;
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.dialog_choose, (ViewGroup) null, false);
        int i = q5.k.close_button;
        ImageButton imageButton = (ImageButton) android.support.v4.media.session.b.l(viewInflate, i);
        if (imageButton != null) {
            i = q5.k.listView;
            ListView listView = (ListView) android.support.v4.media.session.b.l(viewInflate, i);
            if (listView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                this.I0 = new l7.a(relativeLayout, imageButton, listView, 15);
                return relativeLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
