package View.Rest;


import Controller.UserController.IUserController;
import Controller.UserController.UserController;
import View.Rest.Exceptions.NotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("mongo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAPI {

    IUserController controlle = new UserController();



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUser(@PathParam("id") String id){
        System.out.println("Pathname: "+ id);

        return controlle.getUser(id);

    }

    @GET
    @Path("test")
    public Response test(){
        String str =  "[{\"Navn\":\"Røde Rose I\",\"Adresse\":\"Jagtvej 141\",\"tlf\":\"+45 35830072\",\"Venteliste\":\"Venteliste: 48 (heraf 1 søskende) Pladser: 24\",\"Link\":\"https://pasningogskole.kk.dk/institution/35245x0/vuggestuen\"},{\"Navn\":\"Guldberg-Hudegården\",\"Adresse\":\"Arresøgade 20 Guldbergs Plads 12 Yderholmvej 25\",\"tlf\":\"+45 35397586\",\"Venteliste\":\"Venteliste: 12 (heraf 3 søskende) Pladser: 26\",\"Link\":\"https://pasningogskole.kk.dk/institution/35237x0/vuggestuen\"},{\"Navn\":\"Samuelsgården - Vuggestue og Børnehave\",\"Adresse\":\"Rådmandsgade 31\",\"tlf\":\"+45 33663171\",\"Venteliste\":\"Venteliste: 11 (heraf 3 søskende) Pladser: 35\",\"Link\":\"https://pasningogskole.kk.dk/institution/35594x0/vuggestuen\"},{\"Navn\":\"Børnejunglen\",\"Adresse\":\"Rådmandsgade 38 Præstemosevej 31\",\"tlf\":\"+45 35855958\",\"Venteliste\":\"Venteliste: 46 (heraf 6 søskende) Pladser: 44\",\"Link\":\"https://pasningogskole.kk.dk/institution/37460x0/vuggestuen\"},{\"Navn\":\"Den Grønne Giraf\",\"Adresse\":\"Rådmandsgade 11\",\"tlf\":\"+45 35836349\",\"Venteliste\":\"Venteliste: 51 (heraf 4 søskende) Pladser: 44\",\"Link\":\"https://pasningogskole.kk.dk/institution/37258x0/vuggestuen\"},{\"Navn\":\"Fix-Karreen\",\"Adresse\":\"Jagtvej 105D\",\"tlf\":\"+45 35856502\",\"Venteliste\":\"Venteliste: 13 Pladser: 48\",\"Link\":\"https://pasningogskole.kk.dk/institution/37219x0/vuggestuen\"},{\"Navn\":\"Hulahophuset\",\"Adresse\":\"Prinsesse Charlottes Gade 46\",\"tlf\":\"+45 33661399\",\"Venteliste\":\"Venteliste: 55 (heraf 6 søskende) Pladser: 48\",\"Link\":\"https://pasningogskole.kk.dk/institution/37656x0/vuggestuen\"},{\"Navn\":\"Kålormen\",\"Adresse\":\"Allersgade 5\",\"tlf\":\"+45 35830387\",\"Venteliste\":\"Venteliste: 25 (heraf 3 søskende) Pladser: 36\",\"Link\":\"https://pasningogskole.kk.dk/institution/37569x0/vuggestuen\"},{\"Navn\":\"Jagtvejens Asyl Vuggestue\",\"Adresse\":\"Prinsesse Charlottes Gade 59\",\"tlf\":\"+45 35370626\",\"Venteliste\":\"Venteliste: 50 (heraf 1 søskende) Pladser: 27\",\"Link\":\"https://pasningogskole.kk.dk/institution/35541x0/vuggestuen\"},{\"Navn\":\"Olympia\",\"Adresse\":\"Titangade 3\",\"tlf\":\"+45 33666420\",\"Venteliste\":\"Venteliste: 10 Pladser: 40\",\"Link\":\"https://pasningogskole.kk.dk/institution/77004x0/vuggestuen\"},{\"Navn\":\"Dagpleje Nørrebro\",\"Adresse\":\"Nyropsgade 7, 1. sal\",\"tlf\":\"+45 3317 2727\",\"Venteliste\":\"Venteliste: 71 Pladser: 52\",\"Link\":\"https://pasningogskole.kk.dk/dagpleje/5200000\"},{\"Navn\":\"Børnehuset ved Volden\",\"Adresse\":\"Ved Stadsgraven 11\",\"tlf\":\"+45 33662880\",\"Venteliste\":\"Venteliste: 11 (heraf 1 søskende) Pladser: 60\",\"Link\":\"https://pasningogskole.kk.dk/institution/37269x0/vuggestuen\"},{\"Navn\":\"Amagerbro Børnehave\",\"Adresse\":\"Store Mølle Vej 13\",\"tlf\":\"+45 32547566\",\"Venteliste\":\"Venteliste: 13 Pladser: 20\",\"Link\":\"https://pasningogskole.kk.dk/institution/35315x0/vuggestuen\"},{\"Navn\":\"Christianshavns Asyl\",\"Adresse\":\"Amagergade 2\",\"tlf\":\"+45 32542748\",\"Venteliste\":\"Venteliste: 41 (heraf 1 søskende) Pladser: 12\",\"Link\":\"https://pasningogskole.kk.dk/institution/35518x0/vuggestuen\"},{\"Navn\":\"Børnebastionen\",\"Adresse\":\"Amagergade 6\",\"tlf\":\"+45 32963315\",\"Venteliste\":\"Venteliste: 42 Pladser: 20\",\"Link\":\"https://pasningogskole.kk.dk/institution/37483x0/vuggestuen\"},{\"Navn\":\"Anna Wulffs\",\"Adresse\":\"Christianshavns Voldgade 63\",\"tlf\":\"+45 32541113\",\"Venteliste\":\"Venteliste: 26 (heraf 3 søskende) Pladser: 36\",\"Link\":\"https://pasningogskole.kk.dk/institution/35330x0/vuggestuen\"},{\"Navn\":\"Børneinst. v/ Seruminstituttet\",\"Adresse\":\"Amagerfælledvej 38\",\"tlf\":\"+45 32547679\",\"Venteliste\":\"Venteliste: 46 (heraf 2 søskende) Pladser: 24\",\"Link\":\"https://pasningogskole.kk.dk/institution/35225x0/vuggestuen\"},{\"Navn\":\"Blikfang\",\"Adresse\":\"Prinsessegade 58\",\"tlf\":\"+45 32546895\",\"Venteliste\":\"Venteliste: 20 (heraf 3 søskende) Pladser: 24\",\"Link\":\"https://pasningogskole.kk.dk/institution/37447x0/vuggestuen\"},{\"Navn\":\"Smørklatten\",\"Adresse\":\"Christianshavns Voldgade 5B\",\"tlf\":\"+45 32574641\",\"Venteliste\":\"Venteliste: 23 (heraf 1 søskende) Pladser: 23\",\"Link\":\"https://pasningogskole.kk.dk/institution/37233x0/vuggestuen\"},{\"Navn\":\"Sofiegårdens Vuggestue\",\"Adresse\":\"Overgaden Oven Vandet 32B\",\"tlf\":\"+45 32548855\",\"Venteliste\":\"Venteliste: 43 Pladser: 41\",\"Link\":\"https://pasningogskole.kk.dk/institution/35258x0/vuggestuen\"},{\"Navn\":\"Børnehuset Nathanael\",\"Adresse\":\"Holmbladsgade 21\",\"tlf\":\"+45 32542838\",\"Venteliste\":\"Venteliste: 13 Pladser: 12\",\"Link\":\"https://pasningogskole.kk.dk/institution/35532x0/vuggestuen\"},{\"Navn\":\"Dagpleje Amager\",\"Adresse\":\"Nyropsgade 7, 1. sal\",\"tlf\":\"+45 3317 2727\",\"Venteliste\":\"Venteliste: 137 Pladser: 187\",\"Link\":\"https://pasningogskole.kk.dk/dagpleje/5600000\"},{\"Navn\":\"Hyltebro\",\"Adresse\":\"Esromgade 2A\",\"tlf\":\"+45 35854554\",\"Venteliste\":\"Venteliste: 35 (heraf 1 søskende) Pladser: 21\",\"Link\":\"https://pasningogskole.kk.dk/institution/37502x0/vuggestuen\"},{\"Navn\":\"Bifrost/Spanager\",\"Adresse\":\"Baldersgade 5 Spanagervej 14\",\"tlf\":\"+45 35831640\",\"Venteliste\":\"Venteliste: 13 (heraf 3 søskende) Pladser: 48\",\"Link\":\"https://pasningogskole.kk.dk/institution/37229x0/vuggestuen\"},{\"Navn\":\"Børnehuset Balder\",\"Adresse\":\"Baldersgade 3B Rosenlundvej 25A\",\"tlf\":\"+45 33176422\",\"Venteliste\":\"Venteliste: 13 (heraf 3 søskende) Pladser: 50\",\"Link\":\"https://pasningogskole.kk.dk/institution/35506x0/vuggestuen\"},{\"Navn\":\"Midgård\",\"Adresse\":\"Hothers Plads 20 Sennepshaven 62\",\"tlf\":\"+45 35864410\",\"Venteliste\":\"Venteliste: 35 (heraf 7 søskende) Pladser: 54\",\"Link\":\"https://pasningogskole.kk.dk/institution/37474x0/vuggestuen\"},{\"Navn\":\"Asgård\",\"Adresse\":\"Hothers Plads 22\",\"tlf\":\"+45 35864400\",\"Venteliste\":\"Venteliste: 3 (heraf 1 søskende) Pladser: 36\",\"Link\":\"https://pasningogskole.kk.dk/institution/37473x0/vuggestuen\"},{\"Navn\":\"Enighedens Børnehus\",\"Adresse\":\"Bygmestervej 9\",\"tlf\":\"+45 35314600\",\"Venteliste\":\"Venteliste: 84 Pladser: 50\",\"Link\":\"https://pasningogskole.kk.dk/institution/37319x0/vuggestuen\"},{\"Navn\":\"Småbørnenes Forsamlingshus\",\"Adresse\":\"Glentevej 71\",\"tlf\":\"+45 38196719\",\"Venteliste\":\"Venteliste: 48 (heraf 3 søskende) Pladser: 33\",\"Link\":\"https://pasningogskole.kk.dk/institution/37456x0/vuggestuen\"},{\"Navn\":\"Røde Rose 3\",\"Adresse\":\"Heimdalsgade 44\",\"tlf\":\"+45 35832966\",\"Venteliste\":\"Venteliste: 48 (heraf 5 søskende) Pladser: 22\",\"Link\":\"https://pasningogskole.kk.dk/institution/35551x0/vuggestuen\"},{\"Navn\":\"Brolopperne\",\"Adresse\":\"Lundtoftegade 47\",\"tlf\":\"+45 35851773\",\"Venteliste\":\"Venteliste: 7 (heraf 1 søskende) Pladser: 36\",\"Link\":\"https://pasningogskole.kk.dk/institution/37245x0/vuggestuen\"},{\"Navn\":\"Den Grønne Giraf\",\"Adresse\":\"Rådmandsgade 11\",\"tlf\":\"+45 35836349\",\"Venteliste\":\"Venteliste: 51 (heraf 4 søskende) Pladser: 44\",\"Link\":\"https://pasningogskole.kk.dk/institution/37258x0/vuggestuen\"},{\"Navn\":\"Dagpleje Bispebjerg\",\"Adresse\":\"Nyropsgade 7, 1. sal\",\"tlf\":\"+45 3317 2727\",\"Venteliste\":\"Venteliste: 34 Pladser: 9\",\"Link\":\"https://pasningogskole.kk.dk/dagpleje/5300000\"}]\n";

        return Response.ok().entity(str).build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") String id){
     return   controlle.deleteUser(id);
    }

    @GET
    @Path("/getKGardenQuery")
    //Tell what exception will be thrown
    public Response getKGQuery(@QueryParam("name") String name) throws NotFoundException {
        //throws the actual exceoption.
        throw new NotFoundException();

    }

}

