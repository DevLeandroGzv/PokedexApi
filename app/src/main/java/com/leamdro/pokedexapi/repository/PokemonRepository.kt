package com.leamdro.pokedexapi.repository

import com.leamdro.pokedexapi.data.remote.PokeApi
import com.leamdro.pokedexapi.data.remote.responses.Pokemon
import com.leamdro.pokedexapi.data.remote.responses.PokemonList
import com.leamdro.pokedexapi.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api:PokeApi){

suspend fun getPokemonList(limit:Int,offset:Int) : Resource<PokemonList> {
    val response = try{
        api.getPokemonList(limit,offset)
    }catch (e:Exception){
       return  Resource.Error("ha ocurrido un error inesperado")
    }
    return Resource.Success(response)
}

    suspend fun getPokemonInfo(name:String) : Resource<Pokemon> {
        val response = try{
            api.getPokemonInfo(name)
        }catch (e:Exception){
            return  Resource.Error("ha ocurrido un error inesperado")
        }
        return Resource.Success(response)
    }
}